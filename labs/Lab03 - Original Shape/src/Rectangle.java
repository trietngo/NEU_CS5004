/**
 * This class represents a rectangle.  It defines all the operations mandated by
 * the Shape interface
 */
public class Rectangle implements Shape{
    private double width, height;
    private double x, y;

    /**
     * Constructs a rectangle object with the given location of its lower-left
     * corner and dimensions
     * @param x x coordinate of the lower-left corner of this rectangle
     * @param y y coordinate of the lower-left corner of this rectangle
     * @param width width of this rectangle
     * @param height height of this rectangle
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
            this.x,this.y,this.width,this.height);
    }

    /**
     * Calculate the distance of the lower left of the rectangle from the origin.
     * @return the distance of the lower left of the rectangle from the origin.
     */
    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    } // Repetitive

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
        return (this.width + this.height) * 2;
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
            this.x,
            this.y, sqrtFactor *
            this.width,
            sqrtFactor * this.height);
    }

    /**
     * Compares the area of this rectangle with that of the other shape
     * passed into the function
     *      * if (this<s) return a negative number
     *      * if (this==s) return 0
     *      * if (this>s) return a positive number
     * @param s the other shape to be compared to
     * @return
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
