package Model.World;

import Model.World.enums.Climate;
import Model.World.enums.Elevation;
import Model.World.enums.Entity;
import Model.World.enums.Terrain;

/**
 * This class represents a hex tile on the hex map
 * A hex contains the following:
 *  pos: Coordinates
 *  climate: Climate of the tile
 *  elevation: Elevation of the tile (plain, mountains)
 *  terrain: terrain type (grassland, desert, etc.)
 *  entity: add-on (farm, resources, cities, etc.)
 */
public class HexTile {
    public HexPos pos;
    private Climate climate;
    private Elevation elevation;
    private Terrain terrain;
    private Entity entity;

    /**
     * Construct a default hex tile with a Model.HexWorld.HexPos coordinate object
     * Default fields for a hex contain the following:
     *  CONTINENTAL climate
     *  UNDERSEA elevation
     *  OCEAN terrain
     *  NULL entity (nothing)
     * @param pos a Model.HexWorld.HexPos class object
     */
    public HexTile(HexPos pos) {
        this.pos = pos;
        this.climate = Climate.CONTINENTAL;
        this.elevation = Elevation.UNDERSEA;
        this.terrain = Terrain.OCEAN;
        this.entity = Entity.NULL;
    }

    /**
     * Return the X-coordinate of the hex
     * @return the X-coordinate of the hex
     */
    public int getPosX() {
        return pos.getX();
    }

    /**
     * Return the Y-coordinate of the hex
     * @return the Y-coordinate of the hex
     */
    public int getPosY() {
        return pos.getY();
    }

    /**
     * Return the climate of the hex
     * @return the climate of the hex
     */
    public Climate getClimate() {
        return this.climate;
    }

    /**
     * Return the elevation of the hex
     * @return the elevation of the hex
     */
    public Elevation getElevation() {
        return this.elevation;
    }

    /**
     * Return the entity on the hex
     * @return the entity on the hex
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Return the terrain of the hex
     * @return the terrain of the hex
     */
    public Terrain getTerrain() {
        return this.terrain;
    }

    /**
     * Set new value for current hex's climate
     * @param climate desired climate value
     */
    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    /**
     * Set new value for current hex's elevation
     * @param elevation desired elevation value
     */
    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    /**
     * Set new value for current hex's terrain
     * @param terrain desired terrain value
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    /**
     * Set new entity for the current hex
     * @param entity desired entity
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Check if a hex is adjacent to another hex
     * @param target the target hexagon which is a Model.HexWorld.HexTile object
     * @return true or false depending on whether these hexes are
     *         adjacent to one another
     */
    public boolean isAdjacent(HexTile target) {
        int xDiff = Math.abs(target.getPosX() - this.getPosX());
        int yDiff = Math.abs(target.getPosY() - this.getPosY());

        if (xDiff > 1 || yDiff > 1) {
            return false;
        }
        return true;
    }
}
