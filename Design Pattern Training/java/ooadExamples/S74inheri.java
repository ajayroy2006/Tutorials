public abstract class Button {
	...
	public void addActionListener(ActionListener listener) {
		...
	} 
	abstract public void paint(Graphics graphics);
} 
public class LabelButton extends Button {
	private Font labelFont;
	private String labelText;
	public void paint(Graphics graphics) {
		//draw the label text on the graphics using the label's font.
	}
}
public class BitmapButton extends Button {
	private Bitmap bitmap;
	public void paint(Graphics graphics) {
		//draw the bitmap on the graphics.
	}
}
