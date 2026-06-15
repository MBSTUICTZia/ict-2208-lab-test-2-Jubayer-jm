package shapes;

import java.util.Scanner;

public class ShapeMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Shape[] shapes = new Shape[n];

        for (int i = 0; i < n; i++) {
            String type    = sc.next();
            String color   = sc.next();
            boolean filled = sc.nextBoolean();

            if (type.equals("RECTANGLE")) {
                double width  = sc.nextDouble();
                double length = sc.nextDouble();
                shapes[i] = new Rectangle(color, filled, width, length);

            } else if (type.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                shapes[i] = new Circle(color, filled, radius);
            }
        }

        for (Shape s : shapes) {
            System.out.println(s);
            System.out.println();
        }

        System.out.println("--- Downcast Check ---");
        for (Shape s : shapes) {
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                System.out.println("Rectangle width="  + r.getWidth()
                                 + " length=" + r.getLength());
            } else if (s instanceof Circle) {
                Circle c = (Circle) s;
                System.out.println("Circle radius=" + c.getRadius());
            }
        }

        sc.close();
    }
}
