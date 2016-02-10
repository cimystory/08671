/**
 * Octagon shape.
 * @author yuxiz
 *
 */
import java.text.DecimalFormat;
/**
 * class begin.
 *
 */
public class Octagon extends Shape {
    /**
     * side of a octagon.
     */
    private double side;
    /**
     * Constructor with side.
     *
     * @param newSide
     *            side for a new octagon
     */
    public Octagon(double newSide) {
        side = newSide;
    }
    /**
     * Returns area of Octagon object.
     * @return area value of Octagon object
     */
    public double getArea() {
        return 2 * side * side / Math.tan(Math.PI / 8);
    }
    /**
     * Returns perimeter of Octagon object.
     * @return perimeter value of Octagon object
     */
    public double getPerimeter() {
        return 8 * side;
    }
    /**
     * Returns side of octagon object.
     * @return side value of octagon object
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
        return "Octagon " + df.format(getArea()) + " " + df.format(getPerimeter());
    }
}
