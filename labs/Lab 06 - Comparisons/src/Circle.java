/**
 * This class represents a circle.  It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle extends AbstractShape {
    private double radius;

    /**
     * Construct a circle object using the given center and radius
     * @param x x coordinate of the center of this circle
     * @param y y coordinate of the center of this circle
     * @param radius the radius of this circle
     */
    public Circle(double x, double y, double radius) {
        super(new Point2D(x,y));
        this.radius = radius;
    }

    /**
     * Construct a circle object with the given radius. It is centered at (0,0)
     * @param radius the radius of this circle
     */
    public Circle(double radius) {
        super(new Point2D(0,0));
        this.radius = radius;
    }

    /**
     * Calculate the area of the circle using the formula PI * (radius)^2
     * @return the area of the circle
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculate the perimeter of the circle using the formula PI * radius * 2
     * @return the perimeter of the circle
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Create and return a circle with the area resized by the provided factor
     * @param factor factor of resizing
     * @return the resized Circle
     */
    @Override
    public Shape resize(double factor) {
        return new Circle(reference.getX(), reference.getY(), Math.sqrt(factor) *
            radius);
    }

    /**
     * Return the string representation of the Circle object
     * FIELDS
     *        ..this.centerx : double
     *        ..this.centery : double
     *        ..this.radius  : double
     * @return the string representation of the Circle object
     */
    public String toString() {
        return String.format("Circle: center (%.3f,%.3f) radius %.3f",
            this.reference.getX(),this.reference.getY(),this.radius);
    }
}
