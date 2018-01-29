import java.util.Iterator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class IntRange implements Iterable<Integer> {
    private final int lower, upper;
    public IntRange(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int current = lower;
            @Override
            public boolean hasNext() {
                return current <= upper;
            }
            @Override
            public Integer next() {
                return current++;
            }
            @Override
            public void remove() {
                throw new NotImplementedException();
            }
        };
    }
}

public class IteratorDP {
    public static void main(String[] args) {
        for (int n : new IntRange(2, 10))
            System.out.println(n);
    }
}
