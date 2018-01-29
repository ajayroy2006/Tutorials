//Improve the code
class Shape {
    final static int TYPELINE = 0;
    final static int TYPERECTANGLE = 1;
    final static int TYPECIRCLE = 2;
    int shapeType;

    //starting point of the line.
    //lower left corner of the rectangle.
    //center of the circle.
    Point p1;

    //ending point of the line.
    //upper right corner of the rectangle.
    //not used for the circle.
    Point p2;

    int radius;
}
class CADApp {
    void drawShapes(Graphics graphics, Shape shapes[]) {
        for (int i = 0; i < shapes.length; i++) {
            switch (shapes[i].getType()) {
            case Shape.TYPELINE:
                graphics.drawLine(shapes[i].getP1(), shapes[i].getP2());
                break;
            case Shape.TYPERECTANGLE:
                //draw the four edges.
                graphics.drawLine(...);
                graphics.drawLine(...);
                graphics.drawLine(...);
                graphics.drawLine(...);
                break;
            case Shape.TYPECIRCLE:
                graphics.drawCircle(shapes[i].getP1(),
                        shapes[i].getRadius());
                break;
            }
        }
    }
}
