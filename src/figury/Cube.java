package figury;

public class Cube extends Square implements IFigura3d {
    public Cube(double side) {
        super("cube", side);
    }
    public Cube(String name, double side) {
        super(name, side);
    }
    @Override
    public double getArea() {
        return super.getArea()*6;
    }
    public double getVolume() {
        return super.getArea() * super.getSide();
    }
}
