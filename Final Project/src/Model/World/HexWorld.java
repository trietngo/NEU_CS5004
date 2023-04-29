package Model.World;

import Model.World.Interface.HexWorldInterface;
import Model.Player.Player;
import Model.World.enums.Climate;
import Model.World.enums.Elevation;
import Model.World.enums.Entity;
import Model.World.enums.Terrain;
import java.util.ArrayList;

/**
 * This class represents a hex world. It offers all
 * the operations mandated by the Model.HexWorld.HexWorld interface.
 */

public class HexWorld implements HexWorldInterface {
    private ArrayList<ArrayList<HexTile>> hexWorldList;
    private int width;
    private int height;

    /**
     * Construct a hex world with size Width * Height
     * Default world will consist of undersea ocean tiles only with no entities
     * @param WIDTH width (horizontal) input
     * @param HEIGHT height (vertical) input
     */
    public HexWorld(int WIDTH, int HEIGHT) {
        this.width = WIDTH;
        this.height = HEIGHT;

        this.hexWorldList = new ArrayList<>();

        // Generate each row of the map
        for (int i = 0; i < this.height; i++) {
            ArrayList<HexTile> row = new ArrayList<HexTile>();
            hexWorldList.add(row);

            for (int j = 0; j < this.width; j++) {
                row.add(new HexTile(new HexPos(j, i)));
            }
        }
    }

    /**
     * This function returns the hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the hex at input coordinate
     */
    @Override
    public HexTile getHex(int x, int y){

        // Out of bounds
        if (x >= this.width || x < 0 || y >= this.height || y < 0) {
            throw new IllegalArgumentException("Coordinate out of bounds.");
        }

        return hexWorldList.get(y).get(x);
    }

    /**
     * Return the width of the hex world
     * @return the width of the hex world
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return the height of the hex world
     * @return the height of the hex world
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * This function returns the terrain of hex tile at the input coordinates
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the terrain type of the hex at input coordinate
     */
    @Override
    public Terrain getTerrainType(int x, int y) {
        return getHex(x, y).getTerrain();
    }

    /**
     * This function returns the elevation of hex tile at the input coordinates
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the elevation of the hex at input coordinate
     */
    @Override
    public Elevation getTerrainElevation(int x, int y) {
        return getHex(x, y).getElevation();
    }

    /**
     * This function returns the climate of hex tile at the input coordinates
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the climate of the hex at input coordinate
     */
    @Override
    public Climate getTerrainClimate(int x, int y) {
        return getHex(x, y).getClimate();
    }

    /**
     * This function returns the entity of hex tile at the input coordinates
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the terrain entity of the hex at input coordinate
     */
    @Override
    public Entity getTerrainEntity(int x, int y) {
        return getHex(x, y).getEntity();
    }

    /**
     * This function manipulates any hex tile at coordinate (x, y)
     *
     * @param x         x-coordinate of the hex
     * @param y         y-coordinate of the hex
     * @param climate   desired climate type
     * @param elevation desired elevation type
     * @param terrain   desired terrain type
     * @param entity    desired entity
     */
    @Override
    public void setHex(int x, int y, Climate climate, Elevation elevation, Terrain terrain,
        Entity entity) {

        // Get the hex to be manipulated
        HexTile targetHex = getHex(x, y);

        // Set new values
        targetHex.setClimate(climate);
        targetHex.setElevation(elevation);
        targetHex.setEntity(entity);
        targetHex.setTerrain(terrain);
    }

    /**
     * This function set the player position to the new position in the world
     * @param player selected Model.Player.Player
     * @param x target x-coordinate
     * @param y target y-coordinate
     * @return the Model.Player.Player at the new position
     */
    @Override
    public Player setPlayer(Player player, int x, int y) {

        // Get the hex to put the Model on
        HexTile targetHex = this.getHex(x, y);

        // A player cannot be set on non-traversable terrain
        // which includes water and impassable mountains
        if (targetHex.getTerrain().name().equals("OCEAN") ||
            targetHex.getTerrain().name().equals("SEA") ||
            targetHex.getTerrain().name().equals("GLACIER") ||
            targetHex.getTerrain().name().equals("MOUNTAIN")){
            throw new IllegalArgumentException("Cannot put Player here: invalid Terrain.");
        }

        else {
            // Update player coordinates
            player.getPlayerPos(this).setX(x);
            player.getPlayerPos(this).setY(y);
        }

        return player;
    }

}
