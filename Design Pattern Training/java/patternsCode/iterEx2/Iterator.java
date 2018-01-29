package mapFilterReduce;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Iterator {
    private static int sumOfUniqueSqares(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).stream().collect(Collectors.summingInt(x -> x * x));
    }
    private static String compute(List<String> numbers) {
        return numbers.stream().map(x -> x.toUpperCase()).filter(x -> x.length() > 2).collect(Collectors.joining(", "));
    }
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(1, 2, 3, 4);
        System.out.printf("For %s the answer is %s%n", n, sumOfUniqueSqares(n));
        List<String> v = Arrays.asList("abc", "d", "ef", "pqr", "xyz");
        System.out.printf("For %s the answer is %s%n", v, compute(v));
    }
}
