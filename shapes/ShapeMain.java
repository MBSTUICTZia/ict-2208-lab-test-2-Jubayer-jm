package shapes;

import java.util.Scanner;

public class ShapeMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ── TASK 1 ────────────────────────────────────────────
        // Read the number of shapes from input.
        int n = sc.nextInt();

        // ── TASK 2 ────────────────────────────────────────────
        // Declare a Shape array of size n.
        Shape[] shapes = new Shape[n];

        // ── TASK 3 ────────────────────────────────────────────
        // Loop n times. Read shape type, color, filled, dimensions.
        // Create the correct object and store in shapes[i].
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

        // ── TASK 4 ────────────────────────────────────────────
        // Print each shape followed by a blank line.
        for (Shape s : shapes) {
            System.out.println(s);
            System.out.println();
        }

        // ── TASK 5 — Downcasting ─────────────────────────────
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

        // ── TASK 6 — Abstract class (written answer) ──────────
        // What error does the compiler give if you write:
        //     Shape s = new Shape("Red", true);
        //
        // ANSWER: error: Shape is abstract; cannot be instantiated
        //         Abstract class নিজে কখনো object হতে পারে না।
        //         এটা শুধু subclass-দের জন্য একটা চুক্তি/ছাঁচ তৈরি করে।

        sc.close();
    }
}
