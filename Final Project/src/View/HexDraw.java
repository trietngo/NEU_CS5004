// Adapted from
// stackoverflow.com/questions/20734438/algorithm-to-generate-a-hexagonal-grid-with-coordinate-system
// by Mr. Polywhirl, Dec. 23rd, 2013.

/**
 * Importing Java AWT
 */
package View;
import java.awt.*;

/**
 * This class extends the Java Polygon class and
 * represents the hex graphically. Fields include:
 *      - SIDES: Sizes of the polygon. A hex have 6 sides
 *      - center: center of the hexagon, a Point object
 *      - radius: radius of the hexagon
 *      - rotation: how much the hexagon rotates from the center
 */
public class HexDraw extends Polygon {

    private static final int SIDES = 6;

    private Point center;
    private int radius;
    private int rotation = 90;

    /**
     * Construct a hex graphically at the center point
     * @param center center of the hexagon, a Point object
     * @param radius radius of the hexagon
     */
    public HexDraw(Point center, int radius) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];

        this.center = center;
        this.radius = radius;

        hexPoints();
    }

    /**
     * Call the original constructor on a specified (x, y) coordinate
     * @param x target x-coordinate
     * @param y target y-coordinate
     * @param radius radius of the hexagon
     */
    public HexDraw(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    /**
     * Calculates the offset angle for each side of the hex
     * @param ratioOffset the offset ratio
     * @return the offset angle for each side of the hex
     */
    private double findHexAngle(double ratioOffset) {
        return ratioOffset * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    /**
     * Return a Point object containing the coordinate for
     * a vertex of a hexagon
     * @param angle an angle in Radian
     * @return a Point object containing the coordinate for
     * a vertex of a hexagon
     */
    private Point findHexPoint(double angle) {
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);

        return new Point(x, y);
    }

    /**
     * Fill the xpoints and ypoints arrays containing the coordinates
     * of all hex vertices
     */
    protected void hexPoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = findHexAngle((double) p / SIDES);
            Point point = findHexPoint(angle);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
        }
    }

    /**
     * Draw a hexagon
     * @param graphics2D instance of Graphics2D class to allow for drawing
     * @param lineThickness stroke thickness
     * @param colorValue color
     * @param filled whether the shape should be filled
     */
    public void draw(Graphics2D graphics2D, int lineThickness, int colorValue, boolean filled) {

        graphics2D.setColor(new Color(colorValue));
        graphics2D.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));

        if (filled) {
            graphics2D.fillPolygon(xpoints, ypoints, npoints);
        }
        else {
            graphics2D.drawPolygon(xpoints, ypoints, npoints);
        }
    }
}
