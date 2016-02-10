/**
 * The super class for all shapes.
 *
 * @author yuxiz
 *
 */
public abstract class Shape {
    /**
     * area of shape.
     */
    private double area;
    /**
     * perimeter of shape.
     */
    private double perimeter;
    /**
     * Constructor with no param.
     * @param none
     */
    public Shape() {
    };
    /**
     * Returns area of Shape object.
     * @return area value of Shape object
     */
    public abstract double getArea();
    /**
     * Returns perimeter of Shape object.
     * @return perimeter value of Shape object
     */
    public abstract double getPerimeter();
    /**
     * Returns string representation of shape object.
     * @return a string representation of shape object
     */
    public String toString() {
        return "Shape " + String.format("%.3f", area) + " "
                + String.format("%.3f", perimeter);
    }
}
