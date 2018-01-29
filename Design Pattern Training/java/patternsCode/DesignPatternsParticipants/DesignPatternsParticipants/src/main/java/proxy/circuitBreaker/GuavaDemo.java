package proxy.circuitBreaker;
import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;

public class GuavaDemo {
    public static void mainForCircuitBreakerWithGuava(String[] args) {
        RemoteCaller rm = new RemoteCaller();
        TimeLimiter tm = new SimpleTimeLimiter();
        IRemoteCaller rm2 = tm.newProxy(rm, IRemoteCaller.class, 10, TimeUnit.SECONDS);
        rm2.fastMethod();
        System.out.println("Fast Method completed");
        try {
        	rm2.slowMethod();
        	System.out.println("Slow Method completed");
        }
        catch (Exception ex) {
        	System.out.println("Timeout for slow method");
        }
        System.exit(0); //Kills the background ExecutorService
    }
}
