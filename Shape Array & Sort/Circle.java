/**
 * Circle shape.
 * @author yuxiz
 *
 */
import java.text.DecimalFormat;
/**
 * class begin.
 *
 */
public class Circle extends Shape {
    /**
     * radius of a circle.
     */
    private double radius;
    /**
     * Constructor with radius.
     *
     * @param newRadius
     *            radius for a new circle
     */
    public Circle(double newRadius) {
        radius = newRadius;
    }
    /**
     * Returns area of Circle object.
     * @return area value of Circle object
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }
    /**
     * Returns perimeter of Circle object.
     * @return perimeter value of Circle object
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    /**
     * Returns radius of a circle.
     *
     * @return radius value of a circle
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Returns string representation of circle object.
     * @return a string representation of circle object
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.000");
        return "Circle " + df.format(getArea()) + " " + df.format(getPerimeter());
    }
}
