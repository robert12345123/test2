package figury;

public class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        super("circle");
        this.radius = radius;
    }
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    public double getRadius() {
        return radius;
    }
}
