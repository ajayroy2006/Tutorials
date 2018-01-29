import java.util.HashSet;
import java.util.Set;
import static java.util.stream.IntStream.range;
import java.util.stream.IntStream;

class NumberClassifier {
    static public boolean isFactor(int number, int potential_factor) {
        return (number % potential_factor) == 0;
    }
    static public Set<Integer> factors(int number) {
        HashSet<Integer> factors = new HashSet<Integer>();
        factors.add(1);
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (isFactor(number, i)) {
                factors.add(i);
                factors.add(number / i);
            }
        return factors;
    }
    static public int sum(Set<Integer> factors) {
        int sum = 0;
        for (int n : factors)
            sum += n;
        return sum;
    }
    static public boolean isPerfect(int number) {
        return sum(factors(number)) == number;
    }
    static public boolean isAbundant(int number) {
        return sum(factors(number)) > number;
    }
    static public boolean isDeficient(int number) {
        return sum(factors(number)) < number;
    }
}

class NumberClassifierWithLamdas {
    static public boolean isFactor(int number, int potential_factor) {
        return (number % potential_factor) == 0;
    }
    static public IntStream factorsOf(int number) {
        return range(1, number + 1).filter((x) -> (number % x) == 0);
    }
    static public int sum(int number) {
        return factorsOf(number).sum() - number;
    }
    static public boolean isPerfect(int number) {
        return sum(number) == number;
    }
    static public boolean isAbundant(int number) {
        return sum(number) > number;
    }
    static public boolean isDeficient(int number) {
        return sum(number) < number;
    }
}
