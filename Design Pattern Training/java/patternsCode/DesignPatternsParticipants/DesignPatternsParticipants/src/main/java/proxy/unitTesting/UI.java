package proxy.unitTesting;
import java.util.Scanner;

public class UI {
    public static void mainForNumberProcessing(String[] args) {
        try (Scanner kbd = new Scanner(System.in)) {
            System.out.println("Enter positive numbers:");
            inputNumbers(kbd);
        } catch (Exception ignore) {
		}
    }
    private static void inputNumbers(Scanner kbd) throws Exception {
        int n = 0;
        try (FindPrimes bl = new FindPrimes(new WriteNumbers())) {
            while ((n = kbd.nextInt()) > 0)
                bl.process(n);
        }
    }
}
