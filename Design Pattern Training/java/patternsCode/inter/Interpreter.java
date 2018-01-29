import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Product {
	int color, price, size;
	public Product(final int color, final int price, final int size) {
		super();
		this.color = color;
		this.price = price;
		this.size = size;
	}
	@Override public String toString() {
		return String.format("color=%d price=%d size=%d", color,
		        price, size);
	}
}

class ProductFinder {
	List<Product> all = new LinkedList<Product>();
	List<Product> belowPriceAvoidingAColor(final int price,
	        final int color) {
		List<Product> r = new LinkedList<Product>();
		for (Product p : all)
			if ((p.price < price) && (p.color != color))
				r.add(p);
		return Collections.unmodifiableList(r);
	}
	List<Product> selectBy(final Spec s) {
		List<Product> r = new LinkedList<Product>();
		for (Product p : all)
			if (s.isSatisfiedBy(p))
				r.add(p);
		return Collections.unmodifiableList(r);
	}
}

interface Spec {
	boolean isSatisfiedBy(Product p);
}

class BelowPrice implements Spec {
	int price;
	public BelowPrice(final int price) {
		this.price = price;
	}
	@Override public boolean isSatisfiedBy(final Product p) {
		return p.price < price;
	}
}

class ColorSpec implements Spec {
	int color;
	public ColorSpec(final int color) {
		this.color = color;
	}
	@Override public boolean isSatisfiedBy(final Product p) {
		return p.color == color;
	}
}

class NotSpec implements Spec {
	Spec s;
	public NotSpec(final Spec s) {
		this.s = s;
	}
	@Override public boolean isSatisfiedBy(final Product p) {
		return !s.isSatisfiedBy(p);
	}
}

class AndSpec implements Spec {
	Spec s1, s2;
	public AndSpec(final Spec s1, final Spec s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	@Override public boolean isSatisfiedBy(final Product p) {
		return s1.isSatisfiedBy(p) && s2.isSatisfiedBy(p);
	}
}

public class Interpreter {
	private static void printAllProducts(final List<Product> ps) {
		int i = 0;
		for (Product p : ps)
			System.out.printf("%d %s%n", ++i, p);
	}
	public static void main(final String[] args) {
		ProductFinder pf = new ProductFinder();
		pf.all.add(new Product(10, 100, 3));
		pf.all.add(new Product(11, 500, 3));
		pf.all.add(new Product(12, 400, 3));
		//printAllProducts(pf.belowPriceAvoidingAColor(450, 12));
		printAllProducts(pf.selectBy(new AndSpec(new BelowPrice(450),
		        new NotSpec(new ColorSpec(12)))));
	}
}
