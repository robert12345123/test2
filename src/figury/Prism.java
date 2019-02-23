package figury;

public class Prism extends Triangle implements IFigura3d {
    private double height;

    public Prism () {
        super("prism");
        height = 0;
    }
    public Prism (double height, double side) {
        super("prism", side);
        this.height = height;
    }
    public double getArea () {
        double side = this.getSide();
        double pole = side*side*(Math.sqrt(3.0)/4.0) + 3 * height * side /2.0;
        return pole;
    }
    public double getVolume()
    {
        double vol = getSide() * getSide() * height * Math.sqrt(3.0) / 12.0;
        return vol;
    }
    //public void showVolume() {
      //  System.out.println("Prism volume: " + String.format("%.3f", this.getVolume()));
    //}
}
