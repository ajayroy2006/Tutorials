package proxy.circuitBreaker;
import java.io.Closeable;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

class CircuitBreakerManual implements Closeable {
    public static final int MILLISECONDS_PER_SECOND = 1000;
    private static final long TEN_SECONDS = 10L * MILLISECONDS_PER_SECOND;
    private long timeout = TEN_SECONDS;
    private Timer interrupt;
    private volatile Thread originalThread;
    private volatile TimerTask task;
    private final AtomicLong counter = new AtomicLong();
    public void callAntoherProcess(Runnable functionToCall) {
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
	@Override
	public void close() throws IOException {
        //Call when done with this circuitBreaker object.
        interrupt.cancel();
        interrupt = null;		
	}
}
