/**
 * Importing JUnit test suite
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class contains all tests for the Board class
 */
public class BoardTest {
    private Board emptyBoard;
    private Board activeChessBoard;

    private King kingBlack, kingWhite;
    private Queen queenBlack, queenWhite, queenTest;
    private Rook rookBlack, rookWhite;
    private Pawn pawnBlack1, pawnBlack2, pawnWhite1,
        pawnWhite2, pawnWhite3, pawnTest;
    private Bishop bishopBlack, bishopWhite;
    private Knight knightBlack1, knightBlack2, knightWhite1, knightWhite2;

    /**
     * Set up the board with some chess pieces in play
     */
    @Before
    public void boardSetUp() {

        activeChessBoard = new Board();

        kingBlack = (King) activeChessBoard.setPiece(new King(Color.BLACK), 4, 7);
        kingWhite = (King) activeChessBoard.setPiece(new King(Color.WHITE), 2, 5);

        queenBlack = (Queen) activeChessBoard.setPiece(new Queen(Color.BLACK), 0,5);
        queenWhite = (Queen) activeChessBoard.setPiece(new Queen(Color.WHITE), 5,3);

        rookBlack = (Rook) activeChessBoard.setPiece(new Rook(Color.BLACK), 7, 6);
        rookWhite = (Rook) activeChessBoard.setPiece(new Rook(Color.WHITE), 5, 1);

        pawnBlack1 = (Pawn) activeChessBoard.setPiece(new Pawn(Color.BLACK), 6, 7);
        pawnBlack2 = (Pawn) activeChessBoard.setPiece(new Pawn(Color.BLACK), 6, 5);
        pawnWhite1 = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 3, 4);
        pawnWhite2 = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 4, 3);
        pawnWhite3 = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 4, 1);

        bishopBlack = (Bishop) activeChessBoard.setPiece(new Bishop(Color.BLACK), 4, 6);
        bishopWhite = (Bishop) activeChessBoard.setPiece(new Bishop(Color.WHITE), 2, 4);

        knightBlack1 = (Knight) activeChessBoard.setPiece(new Knight(Color.BLACK), 3, 6);
        knightBlack2 = (Knight) activeChessBoard.setPiece(new Knight(Color.BLACK), 5, 4);
        knightWhite1 = (Knight) activeChessBoard.setPiece(new Knight(Color.WHITE), 4, 0);
        knightWhite2 = (Knight) activeChessBoard.setPiece(new Knight(Color.WHITE), 6, 0);
    }

    /**
     * This test makes sure the pieces are at their set coordinates
     */
    @Test
    public void getPiecePositionTest() {
        assertSame(kingBlack, activeChessBoard.getPiece(4,7));
        assertSame(kingWhite, activeChessBoard.getPiece(2,5));

        assertSame(queenBlack, activeChessBoard.getPiece(0,5));
        assertSame(queenWhite, activeChessBoard.getPiece(5,3));

        assertSame(rookBlack, activeChessBoard.getPiece(7,6));
        assertSame(rookWhite, activeChessBoard.getPiece(5,1));

        assertSame(pawnBlack1, activeChessBoard.getPiece(6,7));
        assertSame(pawnBlack2, activeChessBoard.getPiece(6,5));
        assertSame(pawnWhite1, activeChessBoard.getPiece(3,4));
        assertSame(pawnWhite2, activeChessBoard.getPiece(4,3));
        assertSame(pawnWhite3, activeChessBoard.getPiece(4,1));

        assertSame(bishopBlack, activeChessBoard.getPiece(4,6));
        assertSame(bishopWhite, activeChessBoard.getPiece(2,4));

        assertSame(knightBlack1, activeChessBoard.getPiece(3,6));
        assertSame(knightBlack2, activeChessBoard.getPiece(5,4));
        assertSame(knightWhite1, activeChessBoard.getPiece(4,0));
        assertSame(knightWhite2, activeChessBoard.getPiece(6,0));
    }

    /**
     * This test makes sure that getPiece() expects an error
     */
    @Ignore ("getPiece(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void getPiecePositionFail() throws Exception {
        assertSame(knightBlack1, activeChessBoard.getPiece(7,9));
    }

    /**
     * This test attempts to place a chess piece onto an occupied tile
     * which will throw an error
     */
    @Ignore ("setPiece(): Coordinates occupied.")
    @Test (expected = IllegalArgumentException.class)
    public void setPieceOccupiedTestFail() throws Exception {
        queenTest = (Queen) activeChessBoard.setPiece(new Queen(Color.BLACK), 6,7);
    }

    /**
     * This test attempts to place a chess piece outside the board's
     * limit
     */
    @Ignore ("setPiece(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void setPieceOutOfBoundsTestFail() throws Exception {
        queenTest = (Queen) activeChessBoard.setPiece(new Queen(Color.BLACK), 10,0);
    }

    /**
     * This tests whether existing King pieces can move to a specific tile
     */
    @Test
    public void kingCanMoveV2Test() throws Exception {
        // Move into occupied space
        assertEquals(0, kingBlack.canMoveV2(activeChessBoard, 4, 6));
        assertEquals(0, kingWhite.canMoveV2(activeChessBoard, 3, 6));

        // Move adjacent
        assertEquals(1, kingBlack.canMoveV2(activeChessBoard, 3, 7));
        assertEquals(1, kingWhite.canMoveV2(activeChessBoard, 1, 6));

        // Move 2 or more spaces away
        assertEquals(0, kingBlack.canMoveV2(activeChessBoard, 2, 7));
        assertEquals(0, kingWhite.canMoveV2(activeChessBoard, 0, 3));
    }

    /**
     * This test attempts to move a King piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void kingCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, kingWhite.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a King piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void kingCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, kingWhite.canMoveV2(activeChessBoard, kingWhite.getRow(),
            kingWhite.getColumn()));
    }

    /**
     * This tests whether existing Queen pieces can move to a specific tile
     */
    @Test
    public void queenCanMoveV2Test() throws Exception {

        // Vertical movements
        assertEquals(0, queenBlack.canMoveV2(activeChessBoard, 4, 5));
        assertEquals(1, queenWhite.canMoveV2(activeChessBoard, 7, 3));

        // Horizontal movements
        assertEquals(1, queenBlack.canMoveV2(activeChessBoard, 0,7));
        assertEquals(0, queenWhite.canMoveV2(activeChessBoard, 5,6));
        assertEquals(0, queenWhite.canMoveV2(activeChessBoard, 5,0));

        // Move NE
        assertEquals(1, queenWhite.canMoveV2(activeChessBoard, 7,5));

        // Move SW
        assertEquals(1, queenWhite.canMoveV2(activeChessBoard, 4,2));

        // Move SE
        assertEquals(1, queenWhite.canMoveV2(activeChessBoard, 2,6));

        // Move NW
        assertEquals(0, queenBlack.canMoveV2(activeChessBoard, 5,0));

        // Invalid move
        assertEquals(0, queenBlack.canMoveV2(activeChessBoard, 2,6));
    }

    /**
     * This test attempts to move a Queen piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void queenCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, queenBlack.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a Queen piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void queenCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, queenBlack.canMoveV2(activeChessBoard, queenBlack.getRow(),
            queenBlack.getColumn()));
    }

    /**
     * This tests whether existing Rook pieces can move to a specific tile
     */
    @Test
    public void rookCanMoveV2Test() throws Exception {
        // Vertical movements
        assertEquals(1, rookBlack.canMoveV2(activeChessBoard, 6, 6));
        assertEquals(0, rookBlack.canMoveV2(activeChessBoard, 2, 6));

        // Horizontal movements
        assertEquals(1, rookWhite.canMoveV2(activeChessBoard, 5, 2));
        assertEquals(0, rookWhite.canMoveV2(activeChessBoard, 5, 3));

        // Invalid move
        assertEquals(0, rookWhite.canMoveV2(activeChessBoard, 4, 2));
        assertEquals(0, rookWhite.canMoveV2(activeChessBoard, 3, 2));
    }

    /**
     * This test attempts to move a Rook piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void rookCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, rookBlack.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a Rook piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void rookCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, rookWhite.canMoveV2(activeChessBoard, rookWhite.getRow(),
            rookWhite.getColumn()));
    }

    /**
     * This tests whether existing Bishop pieces can move to a specific tile
     */
    @Test
    public void bishopCanMoveV2Test() throws Exception {
        // Move NE
        assertEquals(1, bishopWhite.canMoveV2(activeChessBoard, 3,5));
        assertEquals(0, bishopWhite.canMoveV2(activeChessBoard, 4,6));

        // Move SW
        assertEquals(1, bishopBlack.canMoveV2(activeChessBoard, 3,5));
        assertEquals(0, bishopBlack.canMoveV2(activeChessBoard, 1,3));

        // Move SE
        assertEquals(1, bishopWhite.canMoveV2(activeChessBoard, 0,6));

        // Move NW
        assertEquals(1, bishopWhite.canMoveV2(activeChessBoard, 4,2));
        assertEquals(0, bishopWhite.canMoveV2(activeChessBoard, 5,1));

        // Invalid move
        assertEquals(0, bishopWhite.canMoveV2(activeChessBoard, 0,4));
    }

    /**
     * This test attempts to move a Bishop piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void bishopCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, bishopWhite.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a Bishop piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void bishopCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, bishopBlack.canMoveV2(activeChessBoard, bishopBlack.getRow(),
            bishopBlack.getColumn()));
    }

    /**
     * This tests whether existing Knight pieces can move to a specific tile
     */
    @Test
    public void knightCanMoveV2Test() throws Exception {
        assertEquals(1, knightBlack1.canMoveV2(activeChessBoard, 1, 7));
        assertEquals(1, knightBlack1.canMoveV2(activeChessBoard, 1, 5));
        assertEquals(1, knightBlack1.canMoveV2(activeChessBoard, 5, 5));
        assertEquals(0, knightBlack1.canMoveV2(activeChessBoard, 2, 4));
        assertEquals(0, knightBlack1.canMoveV2(activeChessBoard, 3, 5));

        assertEquals(1, knightBlack2.canMoveV2(activeChessBoard, 4, 2));
        assertEquals(1, knightBlack2.canMoveV2(activeChessBoard, 3, 5));
        assertEquals(1, knightBlack2.canMoveV2(activeChessBoard, 7, 5));
        assertEquals(0, knightBlack2.canMoveV2(activeChessBoard, 4, 6));
        assertEquals(0, knightBlack2.canMoveV2(activeChessBoard, 7, 2));

        assertEquals(1, knightWhite2.canMoveV2(activeChessBoard, 7, 2));
        assertEquals(0, knightWhite2.canMoveV2(activeChessBoard, 4, 1));
    }

    /**
     * This test attempts to move a Knight piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void knightCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, knightWhite1.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a Knight piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void knightCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, knightBlack2.canMoveV2(activeChessBoard, knightBlack2.getRow(),
            knightBlack2.getColumn()));
    }

    /**
     * This tests whether existing Pawn pieces can move to a specific tile
     */
    @Test
    public void pawnCanMoveV2Test() throws Exception {
        // Black pawn
        assertEquals(1, pawnBlack1.canMoveV2(activeChessBoard, 5, 7));
        assertEquals(0, pawnBlack1.canMoveV2(activeChessBoard, 7, 7));

        // White pawn
        assertEquals(1, pawnWhite1.canMoveV2(activeChessBoard, 4, 4));
        assertEquals(0, pawnWhite2.canMoveV2(activeChessBoard, 3, 3));
    }

    /**
     * This test attempts to move a Pawn piece outside the board's limit
     */
    @Ignore ("canMoveV2(): Selected coordinates out of bounds.")
    @Test (expected = IllegalArgumentException.class)
    public void pawnCanMoveV2OutOfBoundsTestFail() throws Exception {
        assertEquals(0, pawnBlack1.canMoveV2(activeChessBoard, 9, 3));
    }

    /**
     * This test attempts to move a Pawn piece onto itself
     */
    @Ignore ("canMoveV2(): Cannot move to itself.")
    @Test (expected = IllegalArgumentException.class)
    public void pawnCanMoveV2InPlaceTestFail() throws Exception {
        assertEquals(0, pawnWhite2.canMoveV2(activeChessBoard, pawnWhite2.getRow(),
            pawnWhite2.getColumn()));
    }

    /**
     * This tests whether existing King pieces can kill a piece at a specific tile
     */
    @Test
    public void kingCanKillV2Test() throws Exception {
        // Can kill
        assertEquals(1, kingWhite.canKillV2(activeChessBoard, knightBlack1));

        // Can't kill, same color
        assertEquals(0, kingBlack.canKillV2(activeChessBoard, knightBlack1));

        // Can't kill, wrong tile
        assertEquals(0, kingBlack.canKillV2(activeChessBoard, pawnWhite1));
    }

    /**
     * This tests whether existing Queen pieces can kill a piece at a specific tile
     */
    @Test
    public void queenCanKillV2Test() throws Exception {
        assertEquals(1, queenBlack.canKillV2(activeChessBoard, kingWhite));
        assertEquals(1, queenBlack.canKillV2(activeChessBoard, pawnWhite3));

        assertEquals(0, queenWhite.canKillV2(activeChessBoard, rookWhite));
        assertEquals(1, queenWhite.canKillV2(activeChessBoard, knightBlack2));
    }

    /**
     * A Queen piece attempts to kill at its current pos
     */
    @Ignore ("canKillV2(): Cannot kill at current pos.")
    @Test (expected = IllegalArgumentException.class)
    public void queenCanKillV2SelfTestFail() throws Exception {
        assertEquals(0, queenBlack.canKillV2(activeChessBoard, queenBlack));
    }

    /**
     * This tests whether existing Rook pieces can kill a piece at a specific tile
     */
    @Test
    public void rookCanKillV2Test() throws Exception {
        pawnTest = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 5, 6);
        assertEquals(1, rookBlack.canKillV2(activeChessBoard, pawnTest));
        assertEquals(0, rookBlack.canKillV2(activeChessBoard, bishopBlack));
        assertEquals(0, rookBlack.canKillV2(activeChessBoard, queenWhite));

        assertEquals(0, rookWhite.canKillV2(activeChessBoard, knightBlack2));
    }

    /**
     * A Rook piece attempts to kill at its current pos
     */
    @Ignore ("canKillV2(): Cannot kill at current pos.")
    @Test (expected = IllegalArgumentException.class)
    public void rookCanKillV2SelfTestFail() throws Exception {
        assertEquals(0, rookWhite.canKillV2(activeChessBoard, rookWhite));
    }

    /**
     * This tests whether existing Bishop pieces can kill a piece at a specific tile
     */
    @Test
    public void bishopCanKillV2Test() throws Exception {
        pawnTest = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 0, 2);

        // Target to the SW
        assertEquals(1, bishopBlack.canKillV2(activeChessBoard, bishopWhite));

        // Target to the NE
        assertEquals(1, bishopWhite.canKillV2(activeChessBoard, bishopBlack));

        // Can't kill, obstacle in the way
        assertEquals(0, bishopBlack.canKillV2(activeChessBoard, pawnTest));

        // Can't kill, same color
        assertEquals(0, bishopWhite.canKillV2(activeChessBoard, pawnTest));
    }

    /**
     * A Bishop piece attempts to kill at its current pos
     */
    @Ignore ("canKillV2(): Cannot kill at current pos.")
    @Test (expected = IllegalArgumentException.class)
    public void bishopCanKillV2SelfTestFail() throws Exception {
        assertEquals(0, bishopBlack.canKillV2(activeChessBoard, bishopBlack));
    }

    /**
     * This tests whether existing Knight pieces can kill a piece at a specific tile
     */
    @Test
    public void knightCanKillV2Test() throws Exception {
        pawnTest = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE), 3, 3);

        // Killable target
        assertEquals(1, knightBlack1.canKillV2(activeChessBoard, bishopWhite));
        assertEquals(1, knightBlack2.canKillV2(activeChessBoard, pawnTest));

        // Can't kill, wrong tile
        assertEquals(0, knightBlack2.canKillV2(activeChessBoard, knightWhite2));
        assertEquals(0, knightWhite2.canKillV2(activeChessBoard, queenBlack));

        // Can't kill, same color
        assertEquals(0, knightBlack2.canKillV2(activeChessBoard, bishopBlack));
        assertEquals(0, knightWhite2.canKillV2(activeChessBoard, pawnWhite3));
    }

    /**
     * A Knight piece attempts to kill at its current pos
     */
    @Ignore ("canKillV2(): Cannot kill at current pos.")
    @Test (expected = IllegalArgumentException.class)
    public void knightCanKillV2SelfTestFail() throws Exception {
        assertEquals(0, knightWhite2.canKillV2(activeChessBoard, knightWhite2));
    }

    /**
     * This tests whether existing Pawn pieces can kill a piece at a specific tile
     */
    @Test
    public void pawnCanKillV2Test() throws Exception {
        pawnTest = (Pawn) activeChessBoard.setPiece(new Pawn(Color.WHITE),3,2);

        assertEquals(1, pawnWhite2.canKillV2(activeChessBoard, knightBlack2));
        assertEquals(0, pawnWhite2.canKillV2(activeChessBoard, pawnTest));

        assertEquals(0, pawnBlack2.canKillV2(activeChessBoard, knightBlack2));

        queenTest = (Queen) activeChessBoard.setPiece(new Queen(Color.WHITE), 5, 6);
        assertEquals(1, pawnBlack1.canKillV2(activeChessBoard, queenTest));
    }
}
