import java.util.function.Consumer;

class C1F {
	int a, b, c;
	public C1F(final int a, final int b, final int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class C1BuilderF {
	boolean ag, bg, cg, dg, eg;
	int a, b, c, d, e;
	C1BuilderF setA(final int a) {
		this.a = a;
		ag = true;
		return this;
	}
	C1BuilderF setB(final int b) {
		this.b = b;
		bg = true;
		return this;
	}
	C1BuilderF setC(final int c) {
		this.c = c;
		cg = true;
		return this;
	}
	static C1F create(Consumer<C1BuilderF> block) {
	  C1BuilderF o = new C1BuilderF();
	  block.accept(o);
		if (!o.ag)
			o.a = 5;
		if (!o.bg)
			o.b = 6;
		if (!o.cg)
			o.c = 50;
		return new C1F(o.a, o.b, o.c);
	}
}

public class BuilderFluent {
  public void demo(){
    C1BuilderF.create(c -> c.setA(20).setB(2).setC(50));
  }
}
