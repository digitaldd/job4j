package pseudo;

public class Paint {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }

    /**
     * @param shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}