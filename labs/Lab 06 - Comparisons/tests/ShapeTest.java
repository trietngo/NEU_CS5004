/**
 * Importing JUnit test suite
 */

import java.beans.Transient;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains all the unit tests for various kinds of shapes
 */
public class ShapeTest {

    /**
     * Initialize the test objects
     */
    Shape circle1,circle2,circle3,rect1,rect2;
    Triangle triTest, triCollinear, triTest2;
    PerimComparator comparison;

    /**
     * Set up testing by giving test objects values
     */
    @Before
    public void setup() {
        circle1 = new Circle(3,4,5);
        circle2 = new Circle(10.32,10.43,10);
        circle3 = new Circle(20);
        rect1 = new Rectangle(5,6,2.5,2);
        rect2 = new Rectangle(2,3,10,10);
        comparison = new PerimComparator();
    }

    /**
     * Tests whether objects have been created with the correct numbers or not.
     * It does this by using their toString methods
     */
    @Test
    public void testObjectData() {
        assertEquals("Circle: center (3.000,4.000) radius 5.000",circle1.toString
            ());
        assertEquals("Circle: center (10.320,10.430) radius 10.000",circle2.toString
            ());
        assertEquals("Circle: center (0.000,0.000) radius 20.000",circle3
            .toString
                ());
        assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000",
            rect1.toString());
        assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" +
            ".000",rect2
            .toString());
    }

    /**
     * Tests whether the area methods work correctly for all shapes
     */
    @Test
    public void testArea() {
        assertEquals(Math.PI*25,circle1.area(),0.001);
        assertEquals(Math.PI*100,circle2.area(),0.001);
        assertEquals(Math.PI*400,circle3.area(),0.001);
        assertEquals(5,rect1.area(),0.001);
        assertEquals(100,rect2.area(),0.001);
    }


    /**
     * Tests whether the perimeter methods work correctly for all shapes
     */
    @Test
    public void testPerimeter() {
        assertEquals(2*Math.PI*5,circle1.perimeter(),0.001);
        assertEquals(2*Math.PI*10,circle2.perimeter(),0.001);
        assertEquals(2*Math.PI*20,circle3.perimeter(),0.001);
        assertEquals(9,rect1.perimeter(),0.001);
        assertEquals(40,rect2.perimeter(),0.001);
    }

    /**
     * Tests whether the resize methods resize correctly for all shapes
     */
    @Test
    public void testResizes() {
        Shape resizedCircle1,resizedCircle2,resizedCircle3,resizedRect1,
            resizedRect2;

        resizedCircle1 = circle1.resize(2.5);
        resizedCircle2 = circle2.resize(0);
        resizedCircle3 = circle3.resize(10);
        resizedRect1 = rect1.resize(12.5);
        resizedRect2 = rect2.resize(0.001);

        assertEquals(2.5*circle1.area(),resizedCircle1.area(),0.001);
        assertEquals(0*circle2.area(),resizedCircle2.area(),0.001);
        assertEquals(10*circle3.area(),resizedCircle3.area(),0.001);
        assertEquals(12.5*rect1.area(),resizedRect1.area(),0.001);
        assertEquals(0.001*rect2.area(),resizedRect2.area(),0.001);
    }

    // TRIANGLE TESTS

    /**
     * Test if the Triangle Constructor works using getter methods
     * to check the coordinates of the newly constructed triangle
     */
    @Test
    public void triangleConstructorTest() {
        triTest = new Triangle(6,9,4,7,2,2);

        assertEquals(6, triTest.reference.getX(), 0);
        assertEquals(9, triTest.reference.getY(), 0);
        assertEquals(4, triTest.vertex1.getX(), 0);
        assertEquals(7, triTest.vertex1.getY(), 0);
        assertEquals(2, triTest.vertex2.getX(), 0);
        assertEquals(2, triTest.vertex2.getY(), 0);
    }

    /**
     * Tests if the Triangle Constructor throws an error if the input
     * contains non-unique vertices
     */
    @Test (expected = IllegalArgumentException.class)
    public void triangleConstructorExceptionTest() {
        triTest = new Triangle(3,6,7,5,3,6);
    }

    /**
     * Tests whether triangles have been created with the correct info or not.
     * It does this by using their toString methods
     */
    @Test
    public void toStringTriangleTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals("Triangle: Reference vertex (6.000,9.000), vertex 1 (4.000,7.000), "
            + "vertex 2 (2.000,2.000)",triTest
            .toString());
    }

    /**
     * Tests whether triangles have been created with the correct info or not.
     * It does this by using their toString methods
     */
    @Test
    public void toStringTriangleCollinearTest() {
        triCollinear = new Triangle(0,1,0,2,0,3);
        assertEquals("Triangle is degenerate: All vertices are on the same line.",
            triCollinear.toString());
    }

    /**
     * Test whether the area() method returns the correct calculations
     */
    @Test
    public void areaTriangleTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(3, triTest.area(), 0.001);
    }

    /**
     * Test whether the area() method returns 0 if 3 vertices
     * of the triangle is collinear
     */
    @Test
    public void areaTriangleCollinearTest() {
        triCollinear = new Triangle(0,1,0,2,0,3);
        assertEquals(0, triCollinear.area(), 0.001);
    }

    /**
     * Test if the Comparator class returns -1 if the current triangle
     * has a greater perimeter
     */
    @Test
    public void comparePerimTriangleGreater() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(1, comparison.compare(triTest, rect1));
    }

    /**
     * Test if the Comparator class returns 0 if the current triangle
     * has the same perimeter as the other shape
     */
    @Test
    public void comparePerimTriangleEqual() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest2 = new Triangle(10,2,6,9,8,7);
        assertEquals(0, comparison.compare(triTest, triTest2));
    }

    /**
     * Test if the Comparator class returns -1 if the current triangle
     * has a smaller perimeter
     */
    @Test
    public void comparePerimTriangleLessThan() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(-1, comparison.compare(triTest, circle2));
    }

    /**
     * Test if compareTo method returns -1 if the current triangle
     * has a smaller area
     */
    @Test
    public void compareToTriangleGreater() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest2 = new Triangle(10,2,6,9,15,7);
        assertEquals(1, triTest2.compareTo(triTest));
    }

    /**
     * Test if compareTo method returns 0 if the current triangle
     * has the same area as the other shape
     */
    @Test
    public void compareToTriangleEqual() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest2 = new Triangle(10,2,6,9,8,7);
        assertEquals(0, triTest.compareTo(triTest2));
    }

    /**
     * Test if the Comparator class returns 0 if the current triangle
     * has the same perimeter as the other shape
     */
    @Test
    public void compareToTriangleLessThan() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(-1, triTest.compareTo(circle2));
    }

    /**
     * Test if the isCollinearTest() method correctly returns an area of 0
     * on a triangle with 3 vertices on the same diagonal line
     */
    @Test
    public void isCollinearDiagonalTest() {
        triCollinear = new Triangle(7,6,4,5,13,8);
        assertEquals(0, triCollinear.area(), 0.001);
    }

    /**
     * Test if the isCollinearTest() method correctly returns an area of 0
     * on a triangle with 3 vertices on the horizontal
     */
    @Test
    public void isCollinearStraightTest() {
        triCollinear = new Triangle(7,6,7,5,7,8);
        assertEquals(0, triCollinear.area(), 0.001);
    }

    /**
     * Test whether the perimeter() method calculates the correct result
     */
    @Test
    public void perimeterTriangleTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(16.275,triTest.perimeter(), 0.001);
    }

    /**
     * Test whether the perimeter() method returns 0 if 3 vertices of the
     * triangle are on the same line
     */
    @Test
    public void perimeterTriangleCollinearTest() {
        triCollinear = new Triangle(0,9,0,6,0,53);
        assertEquals(0, triCollinear.perimeter(), 0.001);
    }

    /**
     * Test whether the resize method works correctly for triangles
     * by comparing current area and resized area. This test also checks
     * if the reference point remains unchanged
     */
    @Test
    public void resizeTriangleTest() {
        Shape resizedTriTest;

        triTest = new Triangle(6,9,4,7,2,2);
        resizedTriTest = triTest.resize(3);

        assertEquals(3 * triTest.area(), resizedTriTest.area(), 0.001);
    }

    /**
     * Test whether the resize method throws an exception when
     * the resizing factor is 0 or less
     */
    @Test (expected = IllegalArgumentException.class)
    public void resizeTriangleExceptionTest() {
        Shape resizedTriTest;

        triTest = new Triangle(6,9,4,7,2,2);
        resizedTriTest = triTest.resize(0);

        assertEquals(3 * triTest.area(), resizedTriTest.area(), 0.001);
    }

    /**
     * Test if the getVertex1 method returns the correct x-coordinates
     */
    @Test
    public void getVertex1TriangleXTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(4, triTest.getVertex1().getX(), 0);
    }

    /**
     * Test if the getVertex1 method returns the correct y-coordinates
     */
    @Test
    public void getVertex1TriangleYTest() {
        triTest2 = new Triangle(2,0,4,8,10,2);
        assertEquals(8, triTest2.getVertex1().getY(),0);
    }

    /**
     * Test if the getVertex2 method returns the correct x-coordinates
     */
    @Test
    public void getVertex2TriangleXTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(2, triTest.getVertex2().getX(),0);
    }

    /**
     * Test if the getVertex2 method returns the correct y-coordinates
     */
    @Test
    public void getVertex2TriangleYTest() {
        triTest2 = new Triangle(2,0,4,8,10,2);
        assertEquals(2, triTest2.getVertex2().getY(), 0);
    }

    /**
     * Test if the Point2D getter method returns the correct x-coordinates
     * at the reference point
     */
    @Test
    public void getTrianglePoint2DGetterXRefTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(6, triTest.reference.getX(), 0);
    }

    /**
     * Test if the Point2D getter method returns the correct y-coordinates
     * at the reference point
     */
    @Test
    public void getTrianglePoint2DGetterYRefTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(9, triTest.reference.getY(), 0);
    }

    /**
     * Test if the Point2D getter method returns the correct x-coordinates
     */
    @Test
    public void getTrianglePoint2DGetterXTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(4, triTest.vertex1.getX(), 0);
    }

    /**
     * Test if the Point2D getter method returns the correct y-coordinates
     */
    @Test
    public void getTrianglePoint2DGetterYTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(2, triTest.vertex2.getY(), 0);
    }

    /**
     * Test if the setVertex1 updates the Triangle attributes correctly
     */
    @Test
    public void setTriangleVertex1Test() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest.setVertex1(new Point2D(3,0));

        assertEquals(3, triTest.vertex1.getX(), 0);
        assertEquals(0, triTest.vertex1.getY(), 0);
    }

    /**
     * Test if the setVertex1 throws an error if the new vertex is not unique
     */
    @Test (expected = IllegalArgumentException.class)
    public void setTriangleVertex1FailTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest.setVertex1(new Point2D(6,9));
    }

    /**
     * Test if the setVertex2 updates the Triangle attributes correctly
     */
    @Test
    public void setTriangleVertex2Test() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest.setVertex2(new Point2D(1,4));

        assertEquals(1, triTest.vertex2.getX(), 0);
        assertEquals(4, triTest.vertex2.getY(), 0);
    }

    /**
     * Test if the setVertex2 throws an error if the new vertex is not unique
     */
    @Test (expected = IllegalArgumentException.class)
    public void setTriangleVertex2FailTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        triTest.setVertex2(new Point2D(4,7));
    }

    /**
     * Test if the distanceToOrigin method returns the correct result
     */
    @Test
    public void distanceFromOriginTriangleTest() {
        triTest = new Triangle(6,9,4,7,2,2);
        assertEquals(10.8166, triTest.distanceFromOrigin(), 0.001);
    }

    /**
     * Test if the distanceToOrigin returns 0 if the reference point is at (0, 0)
     */
    @Test
    public void distanceFromOriginTriangleOriginTest() {
        triTest = new Triangle(0,0,4,7,2,2);
        assertEquals(0, triTest.distanceFromOrigin(), 0.001);
    }
}
