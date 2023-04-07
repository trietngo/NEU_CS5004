/**
 * Import Java ArrayList Utility
 */

import java.util.ArrayList;

/**
 * This interface contains all operations that the TTT game
 * should support.
 */
public interface TicTacToeModel {

    /**
     * Play a move on the board
     * @param p The player in play
     * @param row the row coordinate of the move
     * @param column the column coordinate of the move
     * @throws IllegalArgumentException when the move is out of bounds,
     * the move is in an already occupied tile, or a player makes a move
     * out of turn
     * @throws IllegalStateException when the move is attempted after the
     * game is over
     */
    void move(Player p, int row, int column)
        throws IllegalArgumentException, IllegalStateException;

    /**
     * Get the status of a specified square
     * @param row the row coordinate
     * @param column the column coordinate
     * @return Player X or O depending on the square. Return NUll if
     * the square is empty
     * @throws IllegalArgumentException when the input is out of bounds
     */
    Player getStatus(int row, int column) throws IllegalArgumentException;

    /**
     * Find out whose turn it is in the game
     * @return the Player object in play
     * @throws IllegalStateException when the game is over
     */
    Player currentTurn() throws IllegalStateException;

    /**
     * Check if the game is over
     * @return True if the game is over, False otherwise
     */
    boolean isOver();

    /**
     * Check if the game just started, meaning that the board
     * is empty
     * @return True if the game just started, False if the board is not empty
     * or the game is over
     */
    boolean isStart();

    /**
     * Check if the board is full.
     * Note: The game being over does not necessarily mean
     * that the board is full.
     * @return True if the board is full, meaning the game is over
     * False if the board is not yet full.
     */
    boolean isBoardFull();

    /**
     * Check if a player is the winner or not at any point in the game
     * @param p the player to be evaluated
     * @return True if the player is a winner, False otherwise
     * @throws IllegalArgumentException if the input is not correct
     */
    boolean isWinner(Player p)
        throws IllegalArgumentException;

    /**
     * Return the winner or player NULL if the game ends in a draw
     * @return the winner or player NULL if the game ends in a draw
     * @throws IllegalStateException if the game is not over yet
     */
    Player getWinner() throws IllegalStateException;

    /**
     * Get the representation of the game
     * @return the representation of the game
     * @throws IllegalStateException if the game is not created yet
     */
    ArrayList getBoardState() throws IllegalStateException;
}
