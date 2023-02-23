/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle extends AbstractShape {
    private double width, height;

    /**
     * Constructs a rectangle object with the given location of its lower-left
     * corner and dimensions
     * @param x      x coordinate of the lower-left corner of this rectangle
     * @param y      y coordinate of the lower-left corner of this rectangle
     * @param width  width of this rectangle
     * @param height height of this rectangle
     */
    public Rectangle(double x, double y, double width, double height) {
        super(new Point2D(x, y));
        this.width = width;
        this.height = height;
    }

    /**
     * Calculate the area of the rectangle using the formula width * height
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        return this.width * this.height;
    }

    /**
     * Calculate the perimeter of the rectangle using the formula (width + height) * 2
     * @return the perimeter of the rectangle
     */
    @Override
    public double perimeter() {
        return 2 * (this.width + this.height);
    }

    /**
     * Create and return a rectangle with the area resized by the provided factor.
     * The anchor point of the new rectangle remains the same
     * @param factor factor of resizing
     * @return the resized Rectangle
     */
    @Override
    public Shape resize(double factor) {
        double sqrtFactor = Math.sqrt(factor);
        return new Rectangle(
            this.reference.getX(),
            this.reference.getY(), sqrtFactor *
            this.width,
            sqrtFactor * this.height);
    }

    /**
     * Return the string representation of the Rectangle object
     * FIELDS
     *         ..this.x : double
     *         ..this.y : double
     *         ..this.width  : double
     *         ..this.height : double
     * @return the string representation of the Rectangle object
     */
    public String toString() {
        return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " +
                "%.3f",
            this.reference.getX(), this.reference.getY(), this.width, this
                .height);
    }
}
