//remove the problem in code below
public class Button {
    private Font labelFont;
    private String labelText;
    ...
    public void addActionListener(ActionListener listener) {
        ...
    } 
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