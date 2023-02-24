/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Queen class
 */
public class QueenTest {
    private Queen queenTest;
    private Queen queenTestInvalid;
    private Queen queenTestTarget;

    /**
     * Setting up the main test object
     */
    @Before
    public void queenSetup() throws IllegalArgumentException {
        queenTest = new Queen(4,3, Color.BLACK);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void queenSetupTestFail() throws IllegalArgumentException {
        queenTestInvalid = new Queen(9,6, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color Black
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", queenTest.getColor());
    }

    /**
     * Test if the piece has the correct color White
     */
    @Test
    public void getColorWhiteTest() {
        queenTest = new Queen(4,0, Color.WHITE);
        assertEquals("White", queenTest.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(4, queenTest.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(3, queenTest.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        // Move diagonally along SE-NW axis
        assertEquals(1, queenTest.canMove(5,2));

        // Move diagonally along SW-NE axis
        assertEquals(1, queenTest.canMove(6,5));

        // Move horizontally
        assertEquals(1, queenTest.canMove(4,0));

        // Move vertically
        assertEquals(1, queenTest.canMove(6,3));

        // Can't move
        assertEquals(0, queenTest.canMove(2,2));
        assertEquals(0, queenTest.canMove(2,4));
        assertEquals(0, queenTest.canMove(6,7));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, queenTest.canMove(4,3));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, queenTest.canMove(9,8));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {
        // Different color, valid pos -> can kill
        queenTestTarget = new Queen(2,1, Color.WHITE);
        assertEquals(1, queenTest.canKill(queenTestTarget));

        queenTestTarget = new Queen(4,7, Color.WHITE);
        assertEquals(1, queenTest.canKill(queenTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        queenTestTarget = new Queen(5,0, Color.WHITE);
        assertEquals(0, queenTest.canKill(queenTestTarget));

        // Same color, valid pos -> can't kill
        queenTestTarget = new Queen(4,5, Color.BLACK);
        assertEquals(0, queenTest.canKill(queenTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        queenTestTarget = new Queen(9,0, Color.WHITE);
        assertEquals(0, queenTest.canKill(queenTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        queenTestTarget = new Queen(4,3, Color.WHITE);
        assertEquals(0, queenTest.canKill(queenTestTarget));
    }
}

