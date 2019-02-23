package figury;

public class Cylinder extends Circle implements IFigura3d {
    private double height;
    public Cylinder(double r, double h) {
        super("cylinder", r);
        this.height = h;
    }
    public Cylinder(String name, double r, double h) {
        super(name, r);
        this.height = h;
    }
    public double getArea() {
        double pole = super.getArea()*2 + 2 * Math.PI * height * getRadius();
        return pole;
    }
    public double getVolume() {
        return super.getArea() * height;
    }
}
