/**
 * Import HexWorld package
 */
package Controller;
import Model.World.HexWorld;
import Model.World.enums.Terrain;

/**
 * This class represents hex world which is displayed on the GUI
 */

public class HexWorldController {
    public HexWorld world;

    /**
     * Create a new world to be manipulated
     */
    public HexWorldController() {
        this.world = new HexWorld(14, 9);
    }

    /**
     * Get the created world
     * @return the created world
     */
    public HexWorld getWorld() {
        return this.world;
    }

    /**
     * Build the world with desired characteristics
     */
    public void hexWorldBuilder() {
        world.getHex(4, 5).setTerrain(Terrain.DESERT);
        world.getHex(5, 5).setTerrain(Terrain.DESERT);
        world.getHex(6, 5).setTerrain(Terrain.GRASSLAND);
        world.getHex(7, 5).setTerrain(Terrain.DESERT);
        world.getHex(8, 5).setTerrain(Terrain.DESERT);

        world.getHex(5, 4).setTerrain(Terrain.DESERT);
        world.getHex(6, 3).setTerrain(Terrain.MOUNTAIN);
        world.getHex(7, 2).setTerrain(Terrain.DESERT);
        world.getHex(8, 1).setTerrain(Terrain.DESERT);

        world.getHex(8, 2).setTerrain(Terrain.DESERT);
        world.getHex(8, 3).setTerrain(Terrain.DESERT);
        world.getHex(8, 4).setTerrain(Terrain.DESERT);

        world.getHex(4, 6).setTerrain(Terrain.DESERT);
        world.getHex(5, 6).setTerrain(Terrain.TUNDRA);
        world.getHex(6, 6).setTerrain(Terrain.DESERT);
        world.getHex(7, 6).setTerrain(Terrain.SEA);

        world.getHex(7, 3).setTerrain(Terrain.COAST);
        world.getHex(7, 4).setTerrain(Terrain.GLACIER);
        world.getHex(6, 4).setTerrain(Terrain.COAST);
    }
}
