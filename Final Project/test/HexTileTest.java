/**
 * Import JUnit test suite and relevant modules
 */

import Model.World.HexTile;
import Model.World.HexWorld;
import Model.World.enums.Climate;
import Model.World.enums.Elevation;
import Model.World.enums.Entity;
import Model.World.enums.Terrain;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HexTileTest {
    private HexWorld testWorld;

    /**
     * Set up a detailed world
     */
    @Before
    public void worldSetUpDetailed() {
        testWorld = new HexWorld(14, 9);

        // Set up a pre-made world
        testWorld.getHex(4, 5).setTerrain(Terrain.DESERT);
        testWorld.getHex(5, 5).setTerrain(Terrain.DESERT);
        testWorld.getHex(6, 5).setTerrain(Terrain.GRASSLAND);
        testWorld.getHex(7, 5).setTerrain(Terrain.DESERT);
        testWorld.getHex(8, 5).setTerrain(Terrain.DESERT);

        testWorld.getHex(5, 4).setTerrain(Terrain.DESERT);
        testWorld.getHex(6, 3).setTerrain(Terrain.MOUNTAIN);
        testWorld.getHex(7, 2).setTerrain(Terrain.DESERT);
        testWorld.getHex(8, 1).setTerrain(Terrain.DESERT);

        testWorld.getHex(8, 2).setTerrain(Terrain.DESERT);
        testWorld.getHex(8, 3).setTerrain(Terrain.DESERT);
        testWorld.getHex(8, 4).setTerrain(Terrain.DESERT);

        testWorld.getHex(4, 6).setTerrain(Terrain.DESERT);

        testWorld.getHex(5, 6).setTerrain(Terrain.TUNDRA);
        testWorld.getHex(5, 6).setElevation(Elevation.TERRA);
        testWorld.getHex(5, 6).setClimate(Climate.ARID);
        testWorld.getHex(5, 6).setEntity(Entity.CITY);


        testWorld.getHex(6, 6).setTerrain(Terrain.DESERT);
        testWorld.getHex(7, 6).setTerrain(Terrain.SEA);

        testWorld.getHex(7, 3).setTerrain(Terrain.COAST);
        testWorld.getHex(7, 4).setTerrain(Terrain.GLACIER);
        testWorld.getHex(6, 4).setTerrain(Terrain.COAST);
    }

    /**
     * This tests whether a tile is adjacent to another
     */
    @Test
    public void isAdjacentTest() {
        // Get hexes

        HexTile hex1 = testWorld.getHex(5, 6);
        HexTile hex2 = testWorld.getHex(6, 6);
        HexTile hex3 = testWorld.getHex(1, 2);

        // Test
        assertTrue(hex1.isAdjacent(hex2));
        assertFalse(hex1.isAdjacent(hex3));
    }
}
