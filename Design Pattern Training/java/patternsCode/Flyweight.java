class Point1 {
	private int x, y;
	public Point1(final int x, final int y) {
		super();
		this.x = x;
		this.y = y;
	}
	int getX() {
		return x;
	}
	void setX(final int x) {
		this.x = x;
	}
	int getY() {
		return y;
	}
	void setY(final int y) {
		this.y = y;
	}
	void move(final int dx, final int dy) {
		x += dx;
		y += dy;
	}
	//hashCode and equals can be added
}

class Point2 {
	private final int x, y;
	public Point2(final int x, final int y) {
		super();
		this.x = x;
		this.y = y;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	Point2 move(final int dx, final int dy) {
		return new Point2(x + dx, y + dy);
	}
	//hashCode and equals can be added
}

public class Flyweight {
}
