/**
 * This class represents a circle.  It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle implements Shape {
    private double centerx, centery;
    private double radius;

    /**
     * Construct a circle object using the given center and radius
     * @param x x coordinate of the center of this circle
     * @param y y coordinate of the center of this circle
     * @param radius the radius of this circle
     */
    public Circle(double x, double y, double radius) {
        this.centerx = x;
        this.centery = y;
        this.radius = radius;
    }

    /**
     * Construct a circle object with the given radius. It is centered at (0,0)
     * @param radius the radius of this circle
     */
    public Circle(double radius) {
        this.centerx = 0;
        this.centery = 0;
        this.radius = radius;
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
            this.centerx,this.centery,this.radius);
    }

    /**
     * Calculates the distance of the center of the circle from the origin.
     * @return the distance of the center of the circle from the origin.
     */
    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(this.centerx * this.centerx + this.centery * this.centery);
    } // Repetitive

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
        return Math.PI * radius * 2;
    }

    /**
     * Create and return a circle with the area resized by the provided factor
     * @param factor factor of resizing
     * @return the resized Circle
     */
    @Override
    public Shape resize(double factor) {
        return new Circle(this.centerx, this.centery, Math.sqrt(factor) * radius);
    }

    /**
     * Compares the area of this circle with that of the other shape passed into the function
     * if (this<s) return a negative number
     * if (this==s) return 0
     * if (this>s) return a positive number
     * @param s the other circle to be compared to
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Shape s) {
        double areaThis = this.area();
        double areaOther = s.area();

        if (areaThis < areaOther) {
            return -1;
        } else if (areaOther < areaThis) {
            return 1;
        } else {
            return 0;
        }
    } // Repetitive
}
