/**
 * This class represents a triangle. It offers all the operations mandated by the
 * Shape interface.
 */

public class Triangle extends AbstractShape {
    protected Point2D vertex1;
    protected Point2D vertex2;

    public Triangle(double xRef, double yRef, double x1, double y1, double x2, double y2) {
        super(new Point2D(xRef, yRef));
        if ((xRef != x1 || yRef != y1) && (x1 != x2 || y1 != y2) && (xRef != x2 || yRef != y2)) {
            this.vertex1 = new Point2D(x1, y1);
            this.vertex2 = new Point2D(x2, y2);
        } else {
            throw new IllegalArgumentException("Points aren't unique");
        }
    }

    /**
     * Calculate the length of side A of a triangle, which is
     * defined as the edge connected the reference vertex and vertex 1
     * @return
     */
    private double triangleSideA() {
        double xRef = this.reference.getX();
        double yRef = this.reference.getY();
        double x1 = this.vertex1.getX();
        double y1 = this.vertex1.getY();
        return Math.sqrt(Math.pow(xRef - x1, 2.0) + Math.pow(yRef - y1, 2.0));
    }

    private double triangleSideB() {
        double x1 = this.vertex1.getX();
        double y1 = this.vertex1.getY();

        double x2 = this.vertex2.getX();
        double y2 = this.vertex2.getY();

        return Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
    }

    private double triangleSideC() {
        double xRef = this.reference.getX();
        double yRef = this.reference.getY();

        double x2 = this.vertex2.getX();
        double y2 = this.vertex2.getY();

        return Math.sqrt(Math.pow(x2 - xRef, 2.0) + Math.pow(y2 - yRef, 2.0));
    }

    private Boolean isCollinear() {
        if ((this.triangleSideA() + this.triangleSideB() == this.triangleSideC()) ||
            (this.triangleSideA() + this.triangleSideC() == this.triangleSideB()) ||
            (this.triangleSideB() + this.triangleSideC() == this.triangleSideA())) {
            return true;
        }
        return false;
    }

    public double area() {
        double semiPerimeter = this.perimeter() / 2;

        if (!isCollinear()) {
            return Math.sqrt(semiPerimeter *
                (semiPerimeter - this.triangleSideA()) *
                (semiPerimeter - this.triangleSideB()) *
                (semiPerimeter - this.triangleSideC()));
        }
        return 0;
    }

    public double perimeter() {
        return this.triangleSideA() + this.triangleSideB() + this.triangleSideC();
    }

    public Shape resize(double factor) {
        double sqrtFactor = Math.sqrt(factor);

        double resizedX1 = this.reference.getX() - (this.reference.getX()
            - this.vertex1.getX()) * sqrtFactor;
        double resizedY1 = this.reference.getY() - (this.reference.getY()
            - this.vertex1.getY()) * sqrtFactor;

        double resizedX2 = this.reference.getX() - (this.reference.getX()
            - this.vertex2.getX()) * sqrtFactor;
        double resizedY2 = this.reference.getY() - (this.reference.getY()
            - this.vertex2.getY()) * sqrtFactor;

        return new Triangle(this.reference.getX(), this.reference.getY(),
            resizedX1, resizedY1, resizedX2, resizedY2);
    }

    public String toString() {
        return String.format("Triangle: Reference vertex (%.3f,%.3f), vertex 1 (%.3f,%.3f), "
                + "vertex 2 (%.3f,%.3f)",
            this.reference.getX(), this.reference.getY(),
            this.vertex1.getX(), this.vertex1.getY(),
            this.vertex2.getX(), this.vertex2.getY());
    }
}
