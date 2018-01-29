abstract class State {
	protected GumballMachine g;
	State(final GumballMachine g) {
		this.g = g;
	}
	State coinInserted() {
		return this;
	}
	State leverTurned() {
		return this;
	}
	State ejectPressed() {
		return this;
	}
	boolean hasGumballs() {
		return g.hasGumballs();
	}
}

class NoQuaterState extends State {
	NoQuaterState(final GumballMachine g) {
		super(g);
	}
	@Override State coinInserted() {
		return new HasQuaterState(g);
	}
}

class HasQuaterState extends State {
	HasQuaterState(final GumballMachine g) {
		super(g);
	}
	@Override State coinInserted() {
		System.out.println("Coin refund");
		return this;
	}
	@Override State leverTurned() {
		System.out.println("Gumball dispensed");
		if (hasGumballs())
			return new NoQuaterState(g);
		return new SoldOutState(g);
	}
	@Override State ejectPressed() {
		System.out.println("Coin refund");
		return new NoQuaterState(g);
	}
}

class SoldOutState extends State {
	SoldOutState(final GumballMachine g) {
		super(g);
	}
	@Override State coinInserted() {
		System.out.println("Coin refund");
		return this;
	}
}

class GumballMachine {
	private int gumballs;
	State s = new NoQuaterState(this);
	GumballMachine(final int gumballs) {
		this.gumballs = gumballs;
	}
	void coinInstered() {
		s = s.coinInserted();
	}
	void leverTurned() {
		s = s.leverTurned();
	}
	void ejectPressed() {
		s = s.ejectPressed();
	}
	boolean hasGumballs() {
		gumballs--;
		return gumballs > 0;
	}
}

public class State1 {
	public static void main(final String[] args) {
		GumballMachine g = new GumballMachine(2);
		g.coinInstered();
		g.leverTurned();
		g.coinInstered();
		g.leverTurned();
		g.coinInstered();
		g.leverTurned();
	}
}
