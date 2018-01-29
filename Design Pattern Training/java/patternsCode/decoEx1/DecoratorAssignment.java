import java.util.LinkedList;
import java.util.List;

class LineTracker {
	private int currentLine;
	private final List<Decorator1> headers = new LinkedList<>();
	private final List<Decorator1> footers = new LinkedList<>();
	public static final int LINES_PER_PAGE = 66;

	private LineTracker() {
	}

	private static ThreadLocal<LineTracker> ltr = ThreadLocal
			.withInitial(() -> new LineTracker());

	public static LineTracker getInstance() {
		return ltr.get();
	}

	public static void addHeaderAtStart(Decorator1 d) {
		getInstance().headers.add(0, d);
	}

	public static void addFooterAtEnd(Decorator1 d) {
		getInstance().footers.add(d);
	}

	public static boolean TimeForHeader(Decorator1 d) {
		LineTracker ltr = getInstance();
		return ((ltr.currentLine < ltr.headers.size()) && (ltr.headers
				.get(ltr.currentLine) == d));
	}

	public static boolean TimeForFooter(Decorator1 d) {
		LineTracker ltr = getInstance();
		int footerNumber = LINES_PER_PAGE - ltr.currentLine - 1;
		return (footerNumber < ltr.footers.size())
				&& (ltr.footers.get(footerNumber) == d);
	}

	public static void reset() {
		ltr.remove();
		System.out.println("----------End of Report---------");
	}

	void print(String line) {
		System.out.println(line);
		if (++currentLine < LINES_PER_PAGE)
			return;
		currentLine = 0;
		System.out.println("---New Page---");//
	}
}

abstract class Report {
	public abstract String nextLine();

	public final void printFull() {
		while (true) {
			String s = nextLine();
			if (s == null)
				break;
			LineTracker.getInstance().print(s);
		}
		LineTracker.reset();
	}
}

class LineNumber extends Report {
	int max;
	int currentLine;

	LineNumber(int max) {
		this.max = max;
	}

	@Override
	public String nextLine() {
		return (++currentLine > max) ? null : String.valueOf(currentLine);
	}
}

class CharacterPr extends Report {
	int max;
	char c = 'a';

	CharacterPr(int max) {
		this.max = max;
	}

	@Override
	public String nextLine() {
		char p = c;
		if (++c > 'z')
			c = 'a';
		return (max-- > 0) ? String.valueOf(p) : null;
	}
}

abstract class Decorator1 extends Report {
	Report r;

	Decorator1(Report r) {
		this.r = r;
	}
}

class Header1 extends Decorator1 {
	Header1(Report r) {
		super(r);
		LineTracker.addHeaderAtStart(this);
	}

	@Override
	public String nextLine() {
		return LineTracker.TimeForHeader(this) ? "header 1" : r.nextLine();
	}
}

class Header2 extends Decorator1 {
	Header2(Report r) {
		super(r);
		LineTracker.addHeaderAtStart(this);
	}

	@Override
	public String nextLine() {
		return LineTracker.TimeForHeader(this) ? "header 2" : r.nextLine();
	}
}

class Footer1 extends Decorator1 {
	Footer1(Report r) {
		super(r);
		LineTracker.addFooterAtEnd(this);
	}

	@Override
	public String nextLine() {
		return LineTracker.TimeForFooter(this) ? "footer 1" : r.nextLine();
	}
}

class Footer2 extends Decorator1 {
	Footer2(Report r) {
		super(r);
		LineTracker.addFooterAtEnd(this);
	}

	@Override
	public String nextLine() {
		return LineTracker.TimeForFooter(this) ? "footer 2" : r.nextLine();
	}
}

public class DecoratorAssignment {
	public static void main(String[] args) {
		Report r;
		// r = new LineNumber(500);
		// r = new Header1(new LineNumber(500));
		// r = new Header2(new Header1(new LineNumber(500)));
		// r = new CharacterPr(400);
		// r = new Footer1(new CharacterPr(400));
		// r = new Footer2(new Footer1(new CharacterPr(400)));
		r = new Header1(new Header2(new Footer1(new Footer2(
				new CharacterPr(400)))));
		r.printFull();
	}
}
