class C1 {
	int a, b, c;
	public C1(final int a, final int b, final int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class C1Builder {
	boolean ag, bg, cg;
	int a, b, c;
	C1Builder setA(final int a) {
		this.a = a;
		ag = true;
		return this;
	}
	C1Builder setB(final int b) {
		this.b = b;
		bg = true;
		return this;
	}
	C1Builder setC(final int c) {
		this.c = c;
		cg = true;
		return this;
	}
	C1 giveInstance() {
		if (!ag)
			a = 5;
		if (!bg)
			b = 6;
		if (!cg)
			c = 50;
		return new C1(a, b, c);
	}
}

public class Builder {
  public void demo() {
    new C1Builder().setA(10).setB(22).setC(30).giveInstance();
  }
}
