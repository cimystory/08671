/**
 * shape sort test.
 *
 * @author yuxiz
 *
 */
public class ShapeSortTest {
    /**
     * main method.
     *
     * @param args command line
     */
    public static void main(String[] args) {
        Shape[] shapes = new Shape[args.length];
        for (int i = 0; i < shapes.length; i++) {
            String input = args[i];
            char type = input.charAt(0);
            int parameter = Integer.parseInt(input.substring(1));
            switch (type) {
                case 'C':
                    shapes[i] = new Circle(parameter);
                    break;
                case 'S':
                    shapes[i] = new Square(parameter);
                    break;
                case 'H':
                    shapes[i] = new Hexagon(parameter);
                    break;
                case 'O':
                    shapes[i] = new Octagon(parameter);
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < shapes.length; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[j].getArea() < shapes[i].getArea()) {
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
        }
        for (Shape ascend : shapes) {
            System.out.println(ascend);
        }
        for (int i = 0; i < shapes.length; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[j].getPerimeter() > shapes[i].getPerimeter()) {
                    Shape temp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = temp;
                }
            }
        }
        for (Shape descend : shapes) {
            System.out.println(descend);
        }
    }
}
