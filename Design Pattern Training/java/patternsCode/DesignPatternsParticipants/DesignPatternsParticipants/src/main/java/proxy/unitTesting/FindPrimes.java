package proxy.unitTesting;
public class FindPrimes implements AutoCloseable {
    private final IWriteNumbers fout;
    public FindPrimes(IWriteNumbers fout) {
        this.fout = fout;
    }
    public void process(int n) {
        if (isPrime(n)) fout.write(n);
    }
    private boolean isPrime(int n) {
        for (int i = 2; i <= (n / 2); i++)
            if ((n % i) == 0) return false;
        return true;
    }
    @Override
    public void close() throws Exception {
        fout.close();
    }
}
