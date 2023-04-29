/**
 * Import JUnit Test Suite and relevant modules
 */

import static org.junit.Assert.*;

import Model.World.HexTile;
import Model.World.HexWorld;
import Model.World.enums.Climate;
import Model.World.enums.Elevation;
import Model.World.enums.Entity;
import Model.World.enums.Terrain;
import Model.Player.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains all tests for Model.HexWorld.HexWorld
 */
public class HexWorldTest {
    private HexWorld testWorldDefault;
    private HexWorld testWorld;
    private HexTile testHex;

    /**
     * Set up a default world
     */
    @Before
    public void worldSetUp() {
        testWorldDefault = new HexWorld(8, 5);
    }

    /**
     * Set up a more detailed world
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
     * This tests whether the getHex() method returns the correct
     * hex at the desired location
     */
    @Test
    public void worldGetHex() {
        testHex = testWorldDefault.getHex(2, 3);
        assertEquals(2, testHex.getPosX());
        assertEquals(3, testHex.getPosY());
    }

    /**
     * This test will throw an IllegalArgumentException if
     * getHex function receive out-of-bound coordinates
     */
    @Test (expected = IllegalArgumentException.class)
    public void worldGetHexFail() {
        testHex = testWorldDefault.getHex(2, 8);
        assertEquals(2, testHex.getPosX());
        assertEquals(8, testHex.getPosY());
    }

    /**
     * This test whether each hex has the default
     * characteristics when the world is first generated
     * Methods tested:
     *  getClimate()
     *  getElevation()
     *  getTerrain()
     *  getEntity()
     */
    @Test
    public void defaultHexTest() {

        // Pick 4 random tiles
        HexTile hex1 = testWorldDefault.getHex(2, 1);
        HexTile hex2 = testWorldDefault.getHex(2, 4);
        HexTile hex3 = testWorldDefault.getHex(4, 2);
        HexTile hex4 = testWorldDefault.getHex(6, 3);

        // Test for Climate
        assertEquals("CONTINENTAL", hex1.getClimate().name());
        assertEquals("CONTINENTAL", hex2.getClimate().name());
        assertEquals("CONTINENTAL", hex3.getClimate().name());
        assertEquals("CONTINENTAL", hex4.getClimate().name());

        // Test for Elevation
        assertEquals("UNDERSEA", hex1.getElevation().name());
        assertEquals("UNDERSEA", hex2.getElevation().name());
        assertEquals("UNDERSEA", hex3.getElevation().name());
        assertEquals("UNDERSEA", hex4.getElevation().name());

        // Test for Terrain
        assertEquals("OCEAN", hex1.getTerrain().name());
        assertEquals("OCEAN", hex2.getTerrain().name());
        assertEquals("OCEAN", hex3.getTerrain().name());
        assertEquals("OCEAN", hex4.getTerrain().name());

        // Test for Entity
        assertEquals("NULL", hex1.getEntity().name());
        assertEquals("NULL", hex2.getEntity().name());
        assertEquals("NULL", hex3.getEntity().name());
        assertEquals("NULL", hex4.getEntity().name());
    }

    /**
     * This test whether a hex in the custom-built hex world
     * has the correct attributes
     * Methods tested:
     *  getClimate()
     *  getElevation()
     *  getTerrain()
     *  getEntity()
     */
    @Test
    public void customHexWorldTest() {

        // Pick a random tile
        HexTile hexTest = testWorld.getHex(5, 6);

        // Test for Climate
        assertEquals("ARID", hexTest.getClimate().name());

        // Test for Elevation
        assertEquals("TERRA", hexTest.getElevation().name());

        // Test for Terrain
        assertEquals("TUNDRA", hexTest.getTerrain().name());

        // Test for Entity
        assertEquals("CITY", hexTest.getEntity().name());
    }

    /**
     * Test if setter functions works for a hexagon
     */
    @Test
    public void setHexTest() {
        // Pick a random tile
        HexTile hexTest = testWorld.getHex(5, 6);

        // Change the attributes
        testWorld.setHex(5, 6, Climate.DRY, Elevation.ELEVATED,
            Terrain.COAST, Entity.FARM);

        // Test for new Climate
        assertEquals("DRY", hexTest.getClimate().name());

        // Test for new Elevation
        assertEquals("ELEVATED", hexTest.getElevation().name());

        // Test for new Terrain
        assertEquals("COAST", hexTest.getTerrain().name());

        // Test for new Entity
        assertEquals("FARM", hexTest.getEntity().name());
    }

    /**
     * Set a player on the board and test its position
     */
    @Test
    public void hexWorldSetPlayerTest() {
        // Create a new player
        Player testPlayer = new Player("Saul");

        testWorld.setPlayer(testPlayer, 5, 6);

        // Test position
        assertEquals(5, testPlayer.getPlayerPos(testWorld).getX());
        assertEquals(6, testPlayer.getPlayerPos(testWorld).getY());
    }

    /**
     * Set a player on an out-of-bounds position
     */
    @Test (expected = IllegalArgumentException.class)
    public void hexWorldSetPlayerTestFail() {
        // Create a new player
        Player testPlayer = new Player("Saul");

        testWorld.setPlayer(testPlayer, 20, 6);

        // Test position
        assertEquals(5, testPlayer.getPlayerPos(testWorld).getX());
        assertEquals(6, testPlayer.getPlayerPos(testWorld).getY());
    }

    /**
     * Set a player on an invalid tile position
     */
    @Test (expected = IllegalArgumentException.class)
    public void hexWorldSetPlayerTestTerrainFail() {
        // Create a new player
        Player testPlayer = new Player("Saul");

        testWorld.setPlayer(testPlayer, 6, 3);

        // Test position
        assertEquals(5, testPlayer.currentTile(testWorld).getPosX());
        assertEquals(6, testPlayer.currentTile(testWorld).getPosY());
    }
}
