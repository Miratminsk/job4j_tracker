package stragery;

public class Paint {

    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape square = new Square();
        new Paint().draw(triangle);
        new Paint().draw(square);
    }
}
