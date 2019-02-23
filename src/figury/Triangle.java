package figury;

public class Triangle extends Shape {
    private double side;

    public  Triangle() {
        super("triangle");
        setSide(0);
    }
    public  Triangle(String name) {
        super(name);
        setSide(0);
    }
    public Triangle(double side) {
        super("triangle");
        this.setSide(side);
    }
    public Triangle(String name, double side) {
        super(name);
        this.setSide(side);
    }
    public static Triangle Set(double side) {
        return new Triangle(side);
    }
    public static Triangle Set() {
        return new Triangle();

    }
    public double getArea() {
        double pole = getSide()*getSide() * Math.sqrt(3.0) / 4.0;
        return pole;
    }
    public void showArea() {
        String nazwa = this.getClass().getName();
        nazwa = nazwa.substring(nazwa.indexOf(".")+1);
        System.out.println(nazwa + " area: "  + String.format("%.3f", this.getArea()));
    }
    double getSide() {
        return side;
    }
    void setSide(double side) {
        this.side = side;
    }
}
