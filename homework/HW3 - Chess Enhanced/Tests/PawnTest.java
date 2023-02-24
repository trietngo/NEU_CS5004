/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Pawn class
 */
public class PawnTest {
    private Pawn pawnTestBlack;
    private Pawn pawnTestWhite;
    private Pawn pawnTestInvalid;
    private Pawn pawnTestTarget;
    private Pawn pawnTestEdgeWhite;

    /**
     * Setting up the main test objects
     */
    @Before
    public void pawnSetup() throws IllegalArgumentException {
        pawnTestBlack = new Pawn(7,2, Color.BLACK);
        pawnTestWhite = new Pawn(0,3, Color.WHITE);
    }

    /**
     * Set up error: Chess piece at invalid position
     * (out of bounds)
     */
    @Test (expected = IllegalArgumentException.class)
    public void pawnSetupTestFail() throws IllegalArgumentException {
        pawnTestInvalid = new Pawn(0,8, Color.WHITE);
    }

    /**
     * Test if the piece has the correct color Black
     */
    @Test
    public void getColorBlackTest() {
        assertEquals("Black", pawnTestBlack.getColor());
    }

    /**
     * Test if the piece has the correct color White
     */
    @Test
    public void getColorWhiteTest() {
        assertEquals("White", pawnTestWhite.getColor());
    }

    /**
     * Get the row coordinate of current chess piece
     */
    @Test
    public void getRowTest() {
        assertEquals(7, pawnTestBlack.getRow());
        assertEquals(0, pawnTestWhite.getRow());
    }

    /**
     * Get the column coordinate of current chess piece
     */
    @Test
    public void getColumnTest() {
        assertEquals(2, pawnTestBlack.getColumn());
        assertEquals(3, pawnTestWhite.getColumn());
    }

    /**
     * Test if a chess piece can move to another tile
     * based on its current position
     */
    @Test
    public void canMoveTest() throws IllegalArgumentException {
        // Black piece can move
        assertEquals(1, pawnTestBlack.canMove(6,2));

        // White piece can move
        assertEquals(1, pawnTestWhite.canMove(1,3));

        // Black piece can't move
        assertEquals(0, pawnTestBlack.canMove(7,1));

        // White piece can't move
        assertEquals(0, pawnTestWhite.canMove(1,4));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move to its current position
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveInPlaceTestFail() throws IllegalArgumentException {
        assertEquals(1, pawnTestBlack.canMove(7,2));
        assertEquals(1, pawnTestWhite.canMove(0,3));
    }

    /**
     * The test should throw an error if a chess piece
     * want to move out of the bounds of the board
     */
    @Test (expected = IllegalArgumentException.class)
    public void canMoveOutOfBoundsTestFail() throws IllegalArgumentException {
        assertEquals(1, pawnTestBlack.canMove(8,2));
        assertEquals(1, pawnTestWhite.canMove(-1,3));
    }

    /**
     * Test if the current chess piece can kill
     * another piece based on each piece's position
     */
    @Test
    public void canKillTest() throws IllegalArgumentException {

        // Different color, valid pos -> can kill
        pawnTestTarget = new Pawn(6,1, Color.WHITE);
        assertEquals(1, pawnTestBlack.canKill(pawnTestTarget));

        pawnTestTarget = new Pawn(1,4, Color.BLACK);
        assertEquals(1, pawnTestWhite.canKill(pawnTestTarget));

        pawnTestTarget = new Pawn(6,3, Color.WHITE);
        assertEquals(1, pawnTestBlack.canKill(pawnTestTarget));
    }

    /**
     * Test if the current chess piece cannot kill
     * another piece based on each piece's position
     */
    @Test
    public void cannotKillTest() throws IllegalArgumentException {
        // Different color, wrong pos -> can't kill
        pawnTestTarget = new Pawn(5, 0, Color.WHITE);
        assertEquals(0, pawnTestBlack.canKill(pawnTestTarget));

        pawnTestTarget = new Pawn(0, 4, Color.BLACK);
        assertEquals(0, pawnTestWhite.canKill(pawnTestTarget));

        // Same color, valid pos -> can't kill
        pawnTestTarget = new Pawn(6, 3, Color.BLACK);
        assertEquals(0, pawnTestBlack.canKill(pawnTestTarget));

        pawnTestTarget = new Pawn(1, 2, Color.WHITE);
        assertEquals(0, pawnTestWhite.canKill(pawnTestTarget));
    }

    /**
     * The function should throw an error if the target
     * is out of bounds
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillOutOfBoundsTestFail() throws IllegalArgumentException {
        pawnTestTarget = new Pawn(8,4, Color.BLACK);
        pawnTestEdgeWhite = new Pawn(7,3, Color.WHITE);
        assertEquals(0, pawnTestEdgeWhite.canKill(pawnTestTarget));

    }

    /**
     * The function should throw an error if the target
     * is in its current position (not possible)
     */
    @Test (expected = IllegalArgumentException.class)
    public void canKillSelfTestFail() throws IllegalArgumentException {
        pawnTestTarget = new Pawn(7,2, Color.WHITE);
        assertEquals(0, pawnTestBlack.canKill(pawnTestTarget));
    }
}