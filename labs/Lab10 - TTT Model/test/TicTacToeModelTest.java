/**
 * Import JUnit test suite
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeModelTest {

    private TicTacToeModel game;
    private TicTacToeModel gameStart;
    private TicTacToeModel game2;

    /**
     * Create a 3x3 test game
     */
    @Before
    public void gameSetup() {
        game = new TicTacToeModel();
    }

    /**
     * Test if the move() method works as intended
     */
    @Test
    public void moveTest() {
        game.move(Player.X,1,1);
        assertSame(Player.X, game.getStatus(1,1));

        game.move(Player.O,1,2);
        assertSame(Player.O, game.getStatus(1, 2));
    }

    /**
     * Test if making a move out of bounds will throw
     * an Illegal Argument Exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void moveIllegalArgumentTest() {
        game.move(Player.X, 10, 2);
    }

    /**
     * Test if making a move after the game is over
     * will throw an Illegal State Exception
     */
    @Test (expected = IllegalStateException.class)
    public void moveIllegalStateTest() {

        // Make moves that end the game
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);
        game.move(Player.O,1,1);
        game.move(Player.X,0,2);

        assertTrue(game.isOver());

        // Make a move after the game ended
        game.move(Player.O, 2, 2);
    }

    /**
     * Test if the status of each square is reported correctly
     */
    @Test
    public void getStatusTest() {

        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        // Assert
        assertSame(Player.X, game.getStatus(0,1));
        assertSame(Player.O, game.getStatus(1,0));
    }

    /**
     * Test if the out-of-bound input will throw an Illegal
     * Argument Exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void getStatusOutOfBoundsTest() {
        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        // Assert
        assertSame(Player.X, game.getStatus(5,1));
    }

    /**
     * Test if the correct Player is in play
     */
    @Test
    public void currentTurnTest() {

        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        assertSame(Player.O, game.currentTurn());

        // Make another move
        game.move(Player.O,1,1);
        assertSame(Player.X, game.currentTurn());
    }

    /**
     * Checking for current turn after the game is over should
     * throw an Illegal State Exception
     */
    @Test
    public void currentTurnOverTest() {
        // Make moves that end the game
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);
        game.move(Player.O,1,1);
        game.move(Player.X,0,2);

        assertSame(Player.O, game.currentTurn());
    }

    /**
     * Check if the game is over or not
     */
    @Test
    public void isOverTest() {
        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        assertFalse(game.isOver());

        // Make more moves that end the game
        game.move(Player.O,1,1);
        game.move(Player.X,0,2);

        assertTrue(game.isOver());
    }

    /**
     * Check if the game started
     */
    @Test
    public void isStartTest() {
        gameStart = new TicTacToeModel();
        assertTrue(gameStart.isStart());

        // Play some moves
        gameStart.move(Player.X,0,0);
        gameStart.move(Player.O,1,0);
        assertFalse(gameStart.isStart());
    }

    /**
     * Check if the board is full
     */
    @Test
    public void isBoardFull() {
        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,0,2);
        game.move(Player.X,1,2);

        assertFalse(game.isBoardFull());

        // Make more moves to fill the board
        game.move(Player.O,1,1);
        game.move(Player.X,2,0);
        game.move(Player.O,1,0);
        game.move(Player.X,2,1);
        game.move(Player.O,2,2);
        game.move(Player.X,0,1);

        assertTrue(game.isBoardFull());
    }

    /**
     * Check if the winner is correct
     */
    @Test
    public void isWinnerTest() {
        // Make moves that fill the board and ends in a tie
        game.move(Player.X,0,0);
        game.move(Player.O,0,2);
        game.move(Player.X,1,2);
        game.move(Player.O,1,1);
        game.move(Player.X,2,0);
        game.move(Player.O,1,0);
        game.move(Player.X,2,1);
        game.move(Player.O,2,2);
        game.move(Player.X,0,1);

        assertFalse(game.isWinner(Player.X));
        assertTrue(game.isWinner(Player.NULL));
        assertFalse(game.isWinner(Player.O));
    }

    /**
     * Check the winner, but with a wrong input
     */
    @Test (expected = IllegalArgumentException.class)
    public void isWinnerWrongTest() {
        // Make moves that fill the board and ends in a tie
        game.move(Player.X,0,0);
        game.move(Player.O,0,2);
        game.move(Player.X,1,2);
        game.move(Player.O,1,1);
        game.move(Player.X,2,0);
        game.move(Player.O,1,0);
        game.move(Player.X,2,1);
        game.move(Player.O,2,2);
        game.move(Player.X,0,1);

        assertFalse(game.isWinner(new ArrayList<E>()));
    }

    /**
     * Get the correct winner
     */
    @Test
    public void getWinnerTest() {
        // Make moves that end a game
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);
        game.move(Player.O,1,1);
        game.move(Player.X,0,2);

        assertSame(Player.X, game.getWinner());

        // Make moves that end another game by filling the board
        game2 = new TicTacToeModel();

        game2.move(Player.X,0,0);
        game2.move(Player.O,0,2);
        game2.move(Player.X,1,2);
        game2.move(Player.O,1,1);
        game2.move(Player.X,2,0);
        game2.move(Player.O,1,0);
        game2.move(Player.X,2,1);
        game2.move(Player.O,2,2);
        game2.move(Player.X,0,1);

        assertSame(Player.NULL, game2.getWinner());
    }

    /**
     * If the game is not over, getWinner() throws an Illegal
     * State Exception
     */
    @Test (expected = IllegalStateException.class)
    public void getWinnerIllegalTest() {
        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        assertSame(Player.X, game.getWinner());
    }

    /**
     * Get the ArrayList representation of the game
     */
    @Test
    public void getBoardStateTest() {
        // Make some moves
        game.move(Player.X,0,0);
        game.move(Player.O,1,0);
        game.move(Player.X,0,1);

        assertEquals("[X, X, null, O, null, null, null, null, null]",
            game.getBoardState().toString());

        // Make moves that end the game
        game.move(Player.O,1,1);
        game.move(Player.X,0,2);

        assertEquals("[X, X, X, O, O, null, null, null, null]",
            game.getBoardState().toString());
    }

    /**
     * If the game is not created, getBoardState() throws an Illegal State Exception
     */
    @Test (expected = IllegalStateException.class)
    public void getBoardStateFailTest() {
        assertEquals("[null, null, null, null, null, null, null, null, null]",
            game2.getBoardState().toString());
    }
}
