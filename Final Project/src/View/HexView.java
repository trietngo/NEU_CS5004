package View;

/**
 * Importing Java AWT and Swing, as well as Controller modules
 */
import Controller.HexWorldController;
import Model.World.HexWorld;
import java.awt.*;
import javax.swing.*;

/**
 * This class extends JPanel which allows for the graphic
 * representation of a grid of hexagonal tiles in a 1920x1080p screen
 * Fields include:
 *      - worldController: underlying hex world to be presented
 *      - WIDTH: Width of the panel. Default is 1920
 *      - HEIGHT: Height of the panel. Default is 1080
 */
public class HexView extends JPanel {

    private HexWorldController worldController = new HexWorldController();

    private final int WIDTH = 1920;
    private final int HEIGHT = 1080;

    /**
     * Construct a panel with the default Dimension
     */
    public HexView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    /**
     * Main function for drawing the world
     * @param graphics Graphical Interface for drawing
     */
    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Point origin = new Point(WIDTH / 5, HEIGHT / 6);

        // Build the world from the controller
        this.worldController.hexWorldBuilder();

        // Set the stroke of the pen
        graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_SQUARE,
            BasicStroke.JOIN_MITER));

        // Draw the
        drawHexGridLoop(graphics2D, origin, 40, 3);
    }

    /**
     * Draw a grid of hexagons
     * @param graphics Graphical Interface for drawing
     * @param origin Starting point for the stroke
     * @param radius radius of each hexagon
     * @param padding padding for each hexagon
     */
    private void drawHexGridLoop(Graphics graphics, Point origin, int radius, int padding) {

        // X- and Y-Offsets for each successive hexagon
        double xOff = radius;
        double yOff = radius / 1.75;

        // Get the dimensions of the hex world
        int row = this.worldController.getWorld().getHeight();
        int col = this.worldController.getWorld().getWidth();

        // Loop through the grid and draw
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int x = (int) (origin.x + xOff * Math.sqrt(3) / 2 * (c * 2 + 1 - row + r));
                int y = (int) (origin.y + yOff * r * 2.5);
                drawHex(graphics, c, r, x, y, radius, padding);
            }
        }
    }

    /**
     * Draw a hexagon in the GUI. Colors differ based on the terrain of the hex
     * @param graphics Graphical Interface for drawing
     * @param x x-coordinate of the hex
     * @param y y-coordinate of the hex
     * @param xPos x-coordinate on the panel
     * @param yPos y-coordinate on the panel
     * @param radius radius of each hex
     * @param padding padding of each hex
     */
    private void drawHex(Graphics graphics, int x, int y, int xPos,
        int yPos, int radius, int padding) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        HexWorld world = this.worldController.getWorld();

        HexDraw hex = new HexDraw(xPos, yPos, radius);

        if (world.getHex(x, y).getTerrain().name().equals("OCEAN")) {
            hex.draw(graphics2D, 0, 0x235789, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("DESERT")) {
            hex.draw(graphics2D, 0, 0xF5D45F, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("COAST")) {
            hex.draw(graphics2D, 0, 0x59F8E8, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("GRASSLAND")) {
            hex.draw(graphics2D, 0, 0x568259, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("MOUNTAIN")) {
            hex.draw(graphics2D, 0, 0x000000, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("TUNDRA")) {
            hex.draw(graphics2D, 0, 0xAABDB0, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("SEA")) {
            hex.draw(graphics2D, 0, 0x59B3F7, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }

        else if (world.getHex(x, y).getTerrain().name().equals("GLACIER")) {
            hex.draw(graphics2D, 0, 0xe5f5ff, true);
            hex.draw(graphics2D, padding, 0xffffff, false);
        }
    }
}
