/**
 * Import JUnit testing suite and relevant modules
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
 * This class contains all tests for Player class
 */
public class PlayerTest {

    private HexWorld testWorld;
    private Player testPlayer;

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

        // Create a new the player and set the player onto the map
        testPlayer = new Player("Saul Wexler");
        testWorld.setPlayer(testPlayer, 5, 6);
    }

    /**
     * Test if the player's name is correct
     */
    @Test
    public void getNameTest() {
        assertEquals("Saul Wexler", testPlayer.getName(testWorld));
    }

    /**
     * Test if setting a new name for the player works
     */
    @Test
    public void setNameTest() {
        testPlayer.setName(testWorld, "Kimberly Goodman");
        assertEquals("Kimberly Goodman", testPlayer.getName(testWorld));

        testPlayer.setName(testWorld, "Charles Hamlin");
        assertEquals("Charles Hamlin", testPlayer.getName(testWorld));
    }

    /**
     * Test if player pos is correct
     */
    @Test
    public void getPlayerPosTest() {
        assertEquals(5, testPlayer.getPlayerPos(testWorld).getX());
        assertEquals(6, testPlayer.getPlayerPos(testWorld).getY());
    }

    /**
     * Test if the current tile player is on has correct attributes
     */
    @Test
    public void getPlayerTileTest() {

        HexTile playerTile = testPlayer.currentTile(testWorld);

        // Check Tile position
        assertEquals(5, playerTile.getPosX());
        assertEquals(6, playerTile.getPosY());

        // Check tile attributes
        assertEquals("TUNDRA", playerTile.getTerrain().name());
        assertEquals("ARID", playerTile.getClimate().name());
        assertEquals("TERRA", playerTile.getElevation().name());
        assertEquals("CITY", playerTile.getEntity().name());
    }

    /**
     * Check if the player has 100 fuel at the start
     */
    @Test
    public void getPlayerFuelTest() {
        assertEquals(100, testPlayer.getFuel(testWorld));
    }

    /**
     * Set new fuel count for player and check if it's correct
     */
    @Test
    public void setPlayerFuelTest() {
        testPlayer.setFuel(testWorld, 40);
        assertEquals(40, testPlayer.getFuel(testWorld));

        testPlayer.setFuel(testWorld, 55);
        assertEquals(55, testPlayer.getFuel(testWorld));
    }

    /**
     * Test if the Player can move to another tile
     * Note: Right now the Player can cross the Ocean
     */
    @Test
    public void canMoveTest() {

        // Set target tile
        HexTile target1 = testWorld.getHex(8, 4);
        assertTrue(testPlayer.canMove(testWorld, target1));

        // Set fuel to 0, player cannot move
        testPlayer.setFuel(testWorld, 0);
        assertFalse(testPlayer.canMove(testWorld, target1));

        // Player cannot move, tile is SEA
        HexTile target2 = testWorld.getHex(7, 6);
        assertFalse(testPlayer.canMove(testWorld, target2));
    }

    /**
     * Move player to another tile and test if player is in new tile
     */
    @Test
    public void moveToTest() {
        // Set movable target tile
        HexTile target1 = testWorld.getHex(8, 4);

        // Set new target tile
        HexTile target2 = testWorld.getHex(7, 2);

        // Move to tile and check attributes
        testPlayer.moveTo(testWorld, target1);
        assertEquals(95, testPlayer.getFuel(testWorld));

        testPlayer.moveTo(testWorld, target2);
        assertEquals(90, testPlayer.getFuel(testWorld));
    }

    /**
     * Attempt to move a player that's out of fuel
     */
    @Test (expected = ArithmeticException.class)
    public void moveToFailTest() {
        // Set movable target tile
        HexTile target1 = testWorld.getHex(8, 4);

        // Set fuel to 0
        testPlayer.setFuel(testWorld, 0);

        // Move to tile and check attributes
        testPlayer.moveTo(testWorld, target1);
        assertEquals(95, testPlayer.getFuel(testWorld));
    }

}
