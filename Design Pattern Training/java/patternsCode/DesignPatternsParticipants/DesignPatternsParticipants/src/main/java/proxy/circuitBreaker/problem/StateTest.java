package proxy.circuitBreaker.problem;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import proxy.circuitBreaker.RemoteCaller;
import com.google.common.util.concurrent.UncheckedTimeoutException;

public class StateTest {
    private static final int WAIT_LONG_TIME = 20000;
    State sut = new State();
    int milliSecondsToSleep = 1;
    Runnable r = new Runnable() {
        public void run() {
            RemoteCaller.sleepFor(milliSecondsToSleep);
        }
    };
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void circuit_closed_at_start_and_when_connection_working() {
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
        sut.makeCall(r);
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
        sut.makeCall(r);
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
        sut.makeCall(r);
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
    }
    @Test(expected = UncheckedTimeoutException.class)
    public void timeout_thows_exception() {
        milliSecondsToSleep = StateTest.WAIT_LONG_TIME;
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
        sut.makeCall(r);
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
    }
    @Test
    public void multiple_timeouts_cause_circuit_to_open() {
        milliSecondsToSleep = StateTest.WAIT_LONG_TIME;
        for (int i = 0; i < State.FAILURE_THRESHOLD; ++i) {
            assertThat(sut.current, is(equalTo(CircuitState.Closed)));
            make_call_ignoring_exception_thrown();
        }
        assertThat(sut.current, is(equalTo(CircuitState.Open)));
    }
    @Test(expected = RuntimeException.class)
    public void open_circuit_causes_failure() {
        sut.current = CircuitState.Open;
        sut.makeCall(r);
    }
    @Test
    public void circuit_reset_when_success_in_half_open() {
        sut.current = CircuitState.HalfOpen;
        sut.makeCall(r);
        assertThat(sut.current, is(equalTo(CircuitState.Closed)));
    }
    @Test(expected = UncheckedTimeoutException.class)
    public void cirucit_goes_to_half_open_state_after_some_time() {
        sut.current = CircuitState.Open;
        milliSecondsToSleep = StateTest.WAIT_LONG_TIME;
        int sleepDuration = (int) TimeUnit.MILLISECONDS.convert(State.RESET_TIMEOUT.getNano(),
                TimeUnit.NANOSECONDS);
        RemoteCaller.sleepFor(sleepDuration + 1);
        sut.makeCall(r);
    }
    private void make_call_ignoring_exception_thrown() {
        try {
            sut.makeCall(r);
        } catch (Exception ignore) {
            return;
        }
        fail("Expected Exception not thrown");
    }
}
