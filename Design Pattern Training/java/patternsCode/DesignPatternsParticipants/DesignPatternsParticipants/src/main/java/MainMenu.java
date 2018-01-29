import proxy.circuitBreaker.DemoManual;
import proxy.circuitBreaker.DemoWithLamda;
import proxy.circuitBreaker.GuavaDemo;
import proxy.unitTesting.UI;
import springAspectDemo.Application;

public class MainMenu {
	static final String[] EMPTY = new String[0];

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err
					.println("Specify first argument to determine which app to run.");
			System.exit(1);
		}
		switch (args[0]) {
		case "1":
			Application.mainForSpringAspectDemo(EMPTY);
			break;
		case "2":
			DemoManual.mainForCircuitBreakerManual(EMPTY);
			break;
		case "3":
			DemoWithLamda.mainForCircuitBreakerWithLamda(EMPTY);
			break;
		case "4":
			GuavaDemo.mainForCircuitBreakerWithGuava(EMPTY);
			break;
		case "5":
			UI.mainForNumberProcessing(EMPTY);
			break;
		default:
			System.err.printf("Invalid argument %s%n", args[0]);
			System.err.println("1 - Spring Aspect Demo");
			System.err.println("2 - CircuitBreaker Manual");
			System.err.println("3 - CircuitBreaker with Lamdas");
			System.err.println("4 - CircuitBreaker with Guava library");
			System.err.println("5 - Number processing for proxy in JUnit testing");
		}
	}

}
