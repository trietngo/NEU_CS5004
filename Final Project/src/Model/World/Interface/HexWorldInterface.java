package Model.World.Interface;

import Model.World.HexTile;
import Model.Player.Player;
import Model.World.enums.Climate;
import Model.World.enums.Elevation;
import Model.World.enums.Entity;
import Model.World.enums.Terrain;

/**
 * This interface contains all operations that a hex world
 * should support.
 */

public interface HexWorldInterface {

    /**
     * This function returns the hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the hex at input coordinate
     */
    HexTile getHex(int x, int y);

    /**
     * This function returns the terrain of hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the terrain type of the hex at input coordinate
     */
    Terrain getTerrainType(int x, int y);

    /**
     * This function returns the elevation of hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the elevation of the hex at input coordinate
     */
    Elevation getTerrainElevation(int x, int y);

    /**
     * This function returns the climate of hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the climate of the hex at input coordinate
     */
    Climate getTerrainClimate(int x, int y);

    /**
     * This function returns the entity of hex tile at the input coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @return the terrain entity of the hex at input coordinate
     */
    Entity getTerrainEntity(int x, int y);

    /**
     * This function manipulates any hex tile at coordinate (x, y)
     * @param x x-coordinate of the hex
     * @param y y-coordinate of the hex
     * @param climate desired climate type
     * @param elevation desired elevation type
     * @param terrain desired terrain type
     * @param entity desired entity
     */
    void setHex(int x, int y, Climate climate, Elevation elevation,
        Terrain terrain, Entity entity);

    /**
     * This function set the player position to the new position in the world
     * @param player selected Model.Player.Player
     * @param x target x-coordinate
     * @param y target y-coordinate
     * @return the Model.Player.Player at the new position
     */
    Player setPlayer(Player player, int x, int y);
}
