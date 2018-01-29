package proxy.circuitBreaker;

import java.io.IOException;

public class DemoManual {
	public static void mainForCircuitBreakerManual(final String[] args) {
		try (CircuitBreakerManual c = new CircuitBreakerManual()) {
			c.changeTimeout(3000);
			c.callAntoherProcess(() -> fastFunction());
			c.callAntoherProcess(() -> slowFunction());
		} catch (IOException ignore) {
		}
	}

	private static void fastFunction() {
		try {
			Thread.sleep(2000);
			System.out.println("Fast Function completed");
		} catch (Exception ignore) {
			System.out.println("Fast Function failed");
		}
	}

	private static void slowFunction() {
		try {
			Thread.sleep(20000);
			System.out.println("Slow Function completed");
		} catch (Exception ignore) {
			System.out.println("Slow Function failed");
		}
	}
}
