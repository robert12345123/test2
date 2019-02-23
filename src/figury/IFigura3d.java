package  figury;
public interface IFigura3d {
    double getVolume();
    public default void showVolume() {
        System.out.println("Volume( " + this.toString() + ")= "+ this.getVolume());
    }
}