package bnch.cloning;
import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class C1 implements Serializable, Cloneable {
    private static final long serialVersionUID = -5166172338360791727L;
    int i;
    double j;
    long k1, k2, k3, k4, k5;
    public C1() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        i = rnd.nextInt();
        j = rnd.nextDouble();
        k1 = rnd.nextLong();
        k2 = rnd.nextLong();
        k3 = rnd.nextLong();
        k4 = rnd.nextLong();
        k5 = rnd.nextLong();
    }
    public C1(C1 original) {
        i = original.i;
        j = original.j;
        k1 = original.k1;
        k2 = original.k2;
        k3 = original.k3;
        k4 = original.k4;
        k5 = original.k5;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public C1 callClone() {
        try {
            return (C1) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
