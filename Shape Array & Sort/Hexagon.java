/**
 * Hexagon shape.
 * @author yuxiz
 *
 */
import java.text.DecimalFormat;
/**
 * class begin.
 *
 */
public class Hexagon extends Shape {
    /**
     * side of a hexagon.
     */
    private double side;
    /**
     * Constructor with side.
     *
     * @param newSide
     *            side for a new hexagon
     */
    public Hexagon(double newSide) {
        side = newSide;
    }
    /**
     * Returns area of hexagone object.
     * @return area value of hexagon object
     */
    public double getArea() {
        return Math.sqrt(3) / 2 * side * side * 3;
    }
    /**
     * Returns perimeter of hexagone object.
     * @return perimeter value of hexagon object
     */
    public double getPerimeter() {
        return 6 * side;
    }
    /**
     * Returns side of hexagone object.
     * @return side value of hexagon object
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.000");
        return "Hexagon " + df.format(getArea()) + " " + df.format(getPerimeter());
    }
}
