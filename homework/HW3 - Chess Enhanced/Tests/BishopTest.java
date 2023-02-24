/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Bishop class
 */
public class BishopTest {
    private Bishop bishopTest;
    private Bishop bishopTestInvalid;
    private Bishop bishopTestTarget;

    /**
     * Setting up the main test object
     */
    @Before
    public void bishopSetup() throws IllegalArgumentException {
        bishopTest = new Bishop(2,5, Color.BLACK);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void bishopSetupTestFail() throws IllegalArgumentException {
        bishopTestInvalid = new Bishop(8,2, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color Black
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", bishopTest.getColor());
    }

    /**
     * Test if the piece has the correct color White
     */
    @Test
    public void getColorWhiteTest() {
        bishopTest = new Bishop(2,5, Color.WHITE);
        assertEquals("White", bishopTest.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(2, bishopTest.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(5, bishopTest.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        // Move diagonally along SE-NW axis
        assertEquals(1, bishopTest.canMove(5,2));

        // Move diagonally along SW-NE axis
        assertEquals(1, bishopTest.canMove(3,6));

        // Cannot move horizontally
        assertEquals(0, bishopTest.canMove(2,0));

        // Cannot move vertically
        assertEquals(0, bishopTest.canMove(6,5));

        // Can't move
        assertEquals(0, bishopTest.canMove(2,4));
        assertEquals(0, bishopTest.canMove(6,6));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, bishopTest.canMove(2,5));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, bishopTest.canMove(9,8));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {

        // Different color, valid pos -> can kill
        bishopTestTarget = new Bishop(4,7, Color.WHITE);
        assertEquals(1, bishopTest.canKill(bishopTestTarget));

        bishopTestTarget = new Bishop(6,1, Color.WHITE);
        assertEquals(1, bishopTest.canKill(bishopTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        bishopTestTarget = new Bishop(5, 0, Color.WHITE);
        assertEquals(0, bishopTest.canKill(bishopTestTarget));

        // Same color, valid pos -> can't kill
        bishopTestTarget = new Bishop(3, 6, Color.BLACK);
        assertEquals(0, bishopTest.canKill(bishopTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        bishopTestTarget = new Bishop(8,8, Color.WHITE);
        assertEquals(0, bishopTest.canKill(bishopTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        bishopTestTarget = new Bishop(2,5, Color.WHITE);
        assertEquals(0, bishopTest.canKill(bishopTestTarget));
    }
}


