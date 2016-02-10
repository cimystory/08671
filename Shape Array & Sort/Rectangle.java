/**
 * Rectangle shape.
 * @author yuxiz
 *
 */
import java.text.DecimalFormat;
/**
 * class begin.
 *
 */
public class Rectangle extends Shape {
    /**
     * width of a Rectangle.
     */
    private double width;
    /**
     * height of a Rectangle.
     */
    private double height;
    /**
     * Constructor with new width and new height.
     * @param newWidth new width of Rectangle
     * @param newHeight new height of Rectangle
     */
    public Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
    /**
     * Returns area of Rectangle object.
     * @return area value of Rectangle object
     */
    public double getArea() {
        return width * height;
    }
    /**
     * Returns perimeter of Rectangle object.
     * @return perimeter value of Rectangle object
     */
    public double getPerimeter() {
        return 2 * (width + height);
    }
    /**
     * Returns width of a rectangle object.
     * @return width value of rectangle object
     */
    public double getWidth() {
        return width;
    }
    /**
     * Returns height of a rectangle object.
     * @return height value of rectangle object
     */
    public double getHeight() {
        return height;
    }
    /**
     * Returns string representation of Rectangle object.
     * @return a string representation of rectangle object
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.000");
        return "Rectangle " + df.format(this.getArea()) + " " + df.format(this.getPerimeter());
    }
}
