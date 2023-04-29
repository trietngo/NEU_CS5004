package Model.World;

/**
 * This class represents a hexagonal coordinate (x, y, z).
 */
public class HexPos {
    private int x;
    private int y;

    /**
     * Construct a hex coordinate with the given input
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public HexPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construct a default hex coordinate of (0, 0)
     */
    public HexPos() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Get the x-coordinate
     * @return the x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y-coordinate
     * @return the y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Set new x-coordinate
     * @param x new int x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Set new y-coordinate
     * @param y new int y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
