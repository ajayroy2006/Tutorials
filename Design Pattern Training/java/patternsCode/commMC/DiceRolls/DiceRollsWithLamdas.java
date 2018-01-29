package DiceRolls;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class DiceRollsWithLamdas {
    private static final int N = 100000000;
    public static void main(String[] ignore) {
        parallelDiceRolls().entrySet().forEach(System.out::println);
    }
    public static Map<Integer, Double> parallelDiceRolls() {
        double fraction = 1.0 / N;
        return IntStream.range(0, N).parallel().mapToObj(twoDiceThrows())
                .collect(groupingBy(side -> side, summingDouble(n -> fraction)));
    }
    private static IntFunction<Integer> twoDiceThrows() {
        return i -> oneDiceThrow() + oneDiceThrow();
    }
    private static int oneDiceThrow() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
