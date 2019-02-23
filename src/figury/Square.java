package figury;

public class Square extends Shape{
    private double side;
    public Square() {}
    public Square(double side) {
        super("square");
        this.side = side;
    }
    public Square(String name, double side) {
        super(name);
        this.side = side;
    }
    public double getArea() {
        return getSide() * getSide();
    }

    public double getSide() {
        return side;
    }
    public Cube createCube() {
        return new Cube(this.side);
    }
}
