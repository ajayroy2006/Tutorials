import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

class CircuitBreaker {
	public static final int MILLISECONDS_PER_SECOND = 1000;
	private static final long TEN_SECONDS = 10L * MILLISECONDS_PER_SECOND;
	private long timeout = TEN_SECONDS;
	private Timer interrupt;
	private volatile Thread originalThread;
	private volatile TimerTask task;
	private final AtomicLong counter = new AtomicLong();
	public void callAntoherProcess(final Runnable functionToCall) {
		//Throws InterruptedException, if functionToCall takes more than timeout
		counter.incrementAndGet();
		originalThread = Thread.currentThread();
		createTimerIfNeeded();
		try {
			functionToCall.run();
		} finally {
			synchronized (interrupt) {
				resetInterrupt();
			}
		}
	}
	private void resetInterrupt() {
		originalThread = null;
		task.cancel();
	}
	private void createTimerIfNeeded() {
		if (interrupt == null)
			interrupt = new Timer();
		task = new TimerTask() {
			long currentCount = counter.get();
			@Override
			public void run() {
				timeFinished(currentCount);
			}
		};
		interrupt.schedule(task, timeout);
	}
	private void timeFinished(final long oldCounter) {
		synchronized (interrupt) {
			if ((counter.get() != oldCounter)
			        || (originalThread == null))
				return;
			originalThread.interrupt();
			resetInterrupt();
		}
	}
	public void changeTimeout(final long valueInMilliseconds) {
		timeout = valueInMilliseconds;
	}
	public void dispose() {
		//Call when done with this circuitBreaker object.
		interrupt.cancel();
		interrupt = null;
	}
}
public class M1 {
	public static void main(final String[] args) {
		CircuitBreaker c = new CircuitBreaker();
		c.changeTimeout(3000);
		c.callAntoherProcess(new Runnable() {
			@Override
			public void run() {
				fastFunction();
			}
		});
		c.callAntoherProcess(new Runnable() {
			@Override
			public void run() {
				slowFunction();
			}
		});
		c.dispose();
	}
	private static void fastFunction() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private static void slowFunction() {
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
