/**
 * Square shape.
 * @author yuxiz
 *
 */
import java.text.DecimalFormat;
/**
 * class begin.
 *
 */
public class Square extends Rectangle {
    /**
     * Side value of square.
     */
    private double side;
    /**
     * Constructor with new side.
     * @param newSide new side value of square
     */
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }
    /**
     * Returns area of Square object.
     * @return area value of Square object
     */
    public double getArea() {
        return side * side;
    }
    /**
     * Returns perimeter of Square object.
     * @return perimeter value of Square object
     */
    public double getPerimeter() {
        return 4 * side;
    }
    /**
     * Returns side of square object.
     * @return side value of square object
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
        return "Square " + df.format(getArea()) + " " + df.format(getPerimeter());
    }
}
