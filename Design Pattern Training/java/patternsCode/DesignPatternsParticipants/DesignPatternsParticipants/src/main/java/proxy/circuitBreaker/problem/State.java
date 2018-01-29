package proxy.circuitBreaker.problem;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import proxy.circuitBreaker.IRemoteCaller;
import proxy.circuitBreaker.RemoteCaller;
import com.google.common.util.concurrent.SimpleTimeLimiter;

// As per http://martinfowler.com/bliki/CircuitBreaker.html
enum CircuitState {
	Closed, Open, HalfOpen
}

public class State {
	CircuitState current = CircuitState.Closed;
	long invocationTimeoutInMilliSeconds = 10;
	static final int FAILURE_THRESHOLD = 5;
	static final Duration RESET_TIMEOUT = Duration.ofMillis(100);
	private final int failureCount = 0;
	private final IRemoteCaller remoteCaller;
	private final Instant lastCall = Instant.now();

	public State() {
		remoteCaller = new SimpleTimeLimiter().newProxy(new RemoteCaller(),
				IRemoteCaller.class, invocationTimeoutInMilliSeconds,
				TimeUnit.MILLISECONDS);
	}

	public void makeCall(Runnable r) {
		// To be completed
	}
}
//Complete the above code to make tests in StateTest.java pass.