import java.util.HashSet;
import java.util.Set;

/*
 * The goal is to classify numbers. A number is perfect, if the sum of its
 * factors equals the number e.g. 6 is perfect. The factors are 1, 2, 3. 1 + 2 +
 * 3 equals 6. 
 * A number is abundant, if the sum of its factors is greater than
 * the number e.g. 12 is abundant. The factors are 1, 2, 3, 4 and 6. 1+2+3+4+6
 * is greater than 12.
 * A number is deficient, if the sum of its factors is less
 * than the number e.g. 10 is deficient. The factors are 1, 2, 5. 1+2+5 is less
 * than 10.
 */
class NumberClassifier {
    private final Set<Integer> _factors = new HashSet<Integer>();
    private final int _number;
    public NumberClassifier(int number) {
        if (number < 1)
            throw new RuntimeException(
                    "Can't classify negative numbers");
        _number = number;
        _factors.add(1);
    }
    private boolean isFactor(int factor) {
        return (_number % factor) == 0;
    }
    public Set<Integer> getFactors() {
        return _factors;
    }
    private void calculateFactors() {
        for (int i = 2; i <= Math.sqrt(_number); i++)
            if (isFactor(i))
                addFactor(i);
    }
    private void addFactor(int factor) {
        _factors.add(factor);
        _factors.add(_number / factor);
    }
    private int sumOfFactors() {
        calculateFactors();
        int sum = 0;
        for (int i : _factors)
            sum += i;
        return sum;
    }
    public boolean isPerfect() {
        return sumOfFactors() == _number;
    }
    public boolean isAbundant() {
        return sumOfFactors() > _number;
    }
    public boolean isDeficient() {
        return sumOfFactors() < _number;
    }
    public static boolean isPerfect(int number) {
        return new NumberClassifier(number).isPerfect();
    }
}