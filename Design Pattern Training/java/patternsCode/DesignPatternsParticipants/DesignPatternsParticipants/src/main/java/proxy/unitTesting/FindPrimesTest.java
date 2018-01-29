package proxy.unitTesting;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class FindPrimesTest {
    FindPrimes sut;
    int numberReceived;

    class Mock implements IWriteNumbers {
        @Override
        public void write(int n) {
            numberReceived = n;
        }
        @Override
        public void close() {
        }
    }
    @Before
    public void setUp() {
        sut = new FindPrimes(new Mock());
    }
    @Test
    public void test_prime_number_written() {
        sut.process(7);
        assertThat(numberReceived, is(equalTo(7)));
    }
    @Test
    public void test_nonprime_number_ignored() {
        sut.process(25);
        assertThat(numberReceived, is(equalTo(0)));
    }
}
