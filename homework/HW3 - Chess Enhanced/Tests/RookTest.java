/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Rook class
 */
public class RookTest {
    private Rook rookTest;
    private Rook rookTestInvalid;
    private Rook rookTestTarget;

    /**
     * Setting up the main test object
     */
    @Before
    public void rookSetup() throws IllegalArgumentException {
        rookTest = new Rook(2,1, Color.BLACK);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void rookSetupTestFail() throws IllegalArgumentException {
        rookTestInvalid = new Rook(1,-1, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", rookTest.getColor());
    }

    /**
     * Test if the piece has the correct color
     */
    @Test
    public void getColorWhiteTest() {
        rookTest = new Rook(2,1, Color.WHITE);
        assertEquals("White", rookTest.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(2, rookTest.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(1, rookTest.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        // Move horizontally
        assertEquals(1, rookTest.canMove(2,5));
        assertEquals(1, rookTest.canMove(2,0));

        // Move vertically
        assertEquals(1, rookTest.canMove(1,1));
        assertEquals(1, rookTest.canMove(5,1));

        // Can't move
        assertEquals(0, rookTest.canMove(3,2));
        assertEquals(0, rookTest.canMove(0,0));
        assertEquals(0, rookTest.canMove(6,3));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, rookTest.canMove(2,1));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, rookTest.canMove(9,-8));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {

        // Different color, valid pos -> can kill
        rookTestTarget = new Rook(2,6, Color.WHITE);
        assertEquals(1, rookTest.canKill(rookTestTarget));

        rookTestTarget = new Rook(3,1, Color.WHITE);
        assertEquals(1, rookTest.canKill(rookTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        rookTestTarget = new Rook(5, 0, Color.WHITE);
        assertEquals(0, rookTest.canKill(rookTestTarget));

        // Same color, valid pos -> can't kill
        rookTestTarget = new Rook(4, 1, Color.BLACK);
        assertEquals(0, rookTest.canKill(rookTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        rookTestTarget = new Rook(9,0, Color.WHITE);
        assertEquals(0, rookTest.canKill(rookTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        rookTestTarget = new Rook(2,1, Color.WHITE);
        assertEquals(0, rookTest.canKill(rookTestTarget));
    }
}

