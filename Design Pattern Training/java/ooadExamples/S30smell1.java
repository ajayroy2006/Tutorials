interface Shape {
    void draw(Graphics graphics);
}
class Line implements Shape {
    Point startPoint;
    Point endPoint;
    void draw(Graphics graphics) {
        graphics.drawLine(getStartPoint(), getEndPoint());
    }
}
class Rectangle implements Shape {
    Point lowerLeftCorner;
    Point upperRightCorner;
    void draw(Graphics graphics) {
        graphics.drawLine(...);
        graphics.drawLine(...);
        graphics.drawLine(...);
        graphics.drawLine(...);
    }
}
class Circle implements Shape {
    Point center;
    int radius;
    void draw(Graphics graphics) {
        graphics.drawCircle(getCenter(), getRadius());
    }
}
class CADApp {
    void drawShapes(Graphics graphics, Shape shapes[]) {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw(graphics);
        }
    }
}
