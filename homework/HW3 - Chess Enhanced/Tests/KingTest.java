/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the King class
 */
public class KingTest {
    private King kingTest;
    private King kingTestInvalid;
    private King kingTestTarget;

    /**
     * Setting up the main test object
     */
    @Before
    public void kingSetup() throws IllegalArgumentException {
        kingTest = new King(4,0, Color.BLACK);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void kingSetupTestFail() throws IllegalArgumentException {
        kingTestInvalid = new King(9,6, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color Black
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", kingTest.getColor());
    }

    /**
     * Test if the piece has the correct color White
     */
    @Test
    public void getColorWhiteTest() {
        kingTest = new King(4,0, Color.WHITE);
        assertEquals("White", kingTest.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(4, kingTest.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(0, kingTest.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        assertEquals(1, kingTest.canMove(3,1));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, kingTest.canMove(4,0));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, kingTest.canMove(8,0));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {
        // Different color, valid pos -> can kill
        kingTestTarget = new King(3,1, Color.WHITE);
        assertEquals(1, kingTest.canKill(kingTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        kingTestTarget = new King(6,0, Color.WHITE);
        assertEquals(0, kingTest.canKill(kingTestTarget));

        // Same color, valid pos -> can't kill
        kingTestTarget = new King(3,0, Color.BLACK);
        assertEquals(0, kingTest.canKill(kingTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        kingTestTarget = new King(9,0, Color.WHITE);
        assertEquals(0, kingTest.canKill(kingTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        kingTestTarget = new King(4,0, Color.WHITE);
        assertEquals(0, kingTest.canKill(kingTestTarget));
    }
}
