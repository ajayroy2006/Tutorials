package proxy.circuitBreaker;
public class RemoteCaller implements IRemoteCaller {
    public static void sleepFor(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
        }
    }
    public void fastMethod() {
        sleepFor(1);
    }
    public void slowMethod() {
        sleepFor(20000);
    }
    public void execute(Runnable r) {
        r.run();
    }
}
