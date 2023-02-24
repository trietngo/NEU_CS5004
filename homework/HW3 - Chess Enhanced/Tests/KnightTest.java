/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Knight class
 */
public class KnightTest {
    private Knight knightTest;
    private Knight knightTestInvalid;
    private Knight knightTestTarget;

    /**
     * Setting up the main test object
     */
    @Before
    public void knightSetup() throws IllegalArgumentException {
        knightTest = new Knight(4,5, Color.BLACK);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void knightSetupTestFail() throws IllegalArgumentException {
        knightTestInvalid = new Knight(8,6, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color Black
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", knightTest.getColor());
    }

    /**
     * Test if the piece has the correct color White
     */
    @Test
    public void getColorWhiteTest() {
        knightTest = new Knight(4,5, Color.WHITE);
        assertEquals("White", knightTest.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(4, knightTest.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(5, knightTest.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        // Move 2 rows away
        assertEquals(1, knightTest.canMove(6,4));
        assertEquals(1, knightTest.canMove(2,6));

        // Move 1 row away
        assertEquals(1, knightTest.canMove(5,3));
        assertEquals(1, knightTest.canMove(3,7));

        // Can't move
        assertEquals(0, knightTest.canMove(2,2));
        assertEquals(0, knightTest.canMove(2,7));
        assertEquals(0, knightTest.canMove(6,5));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, knightTest.canMove(4,5));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, knightTest.canMove(0,8));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {

        // Different color, valid pos -> can kill
        knightTestTarget = new Knight(5,7, Color.WHITE);
        assertEquals(1, knightTest.canKill(knightTestTarget));

        knightTestTarget = new Knight(6,6, Color.WHITE);
        assertEquals(1, knightTest.canKill(knightTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        knightTestTarget = new Knight(5, 0, Color.WHITE);
        assertEquals(0, knightTest.canKill(knightTestTarget));

        // Same color, valid pos -> can't kill
        knightTestTarget = new Knight(2, 5, Color.BLACK);
        assertEquals(0, knightTest.canKill(knightTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        knightTestTarget = new Knight(9,0, Color.WHITE);
        assertEquals(0, knightTest.canKill(knightTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        knightTestTarget = new Knight(4,5, Color.WHITE);
        assertEquals(0, knightTest.canKill(knightTestTarget));
    }
}

