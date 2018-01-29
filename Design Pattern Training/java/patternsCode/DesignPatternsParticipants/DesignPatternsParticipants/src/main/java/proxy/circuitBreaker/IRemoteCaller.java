package proxy.circuitBreaker;
public interface IRemoteCaller {
    void fastMethod();
    void slowMethod();
    void execute(Runnable r);
}
