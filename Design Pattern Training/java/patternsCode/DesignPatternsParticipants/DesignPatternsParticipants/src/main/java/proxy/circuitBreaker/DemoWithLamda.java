package proxy.circuitBreaker;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class DemoWithLamda {
    public static void mainForCircuitBreakerWithLamda(String[] args) {
        RemoteCaller rm = new RemoteCaller();
        try {
        	CompletableFuture.runAsync(() -> rm.fastMethod()).get(10, TimeUnit.SECONDS); //No exception is thrown
        	System.out.println("Fast Method completed");
        	CompletableFuture.runAsync(() -> rm.slowMethod()).get(10, TimeUnit.SECONDS); //Exception is thrown
        	System.out.println("Slow Method completed");
        } catch (Exception ignore) {
        	System.out.println("Timeout. Method aborted.");
        }
    }
}
//This example will work only in Java 8. It does not use the proxy design pattern.