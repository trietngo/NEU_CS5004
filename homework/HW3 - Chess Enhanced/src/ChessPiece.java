/**
 * This interface contains all operations that all types of chess pieces
 * should support.
 */
public interface ChessPiece {

    /**
     * The function returns the row coordinate of a chess piece
     * @return the row coordinate of a chess piece
     */
    int getRow();

    /**
     * The function returns the column coordinate of a chess piece
     * @return the column coordinate of a chess piece
     */
    int getColumn();

    /**
     * The function sets the row coordinate of a chess piece
     * @param row an integer represent the new row coordinate
     * @return the new row coordinate of a chess piece
     */
    int setRow(int row);

    /**
     * The function sets the column coordinate of a chess piece
     * @param col an integer represent the new column coordinate
     * @return the new row coordinate of a chess piece
     */
    int setColumn(int col);

    /**
     * The function returns the color of a chess piece
     * @return the string form of the color of a chess piece
     */
    String getColor();

    /**
     * Check if the current piece can move to another tile
     * @param row an integer representing the desired row coordinate
     * @param col an integer representing the desired column coordinate
     * @return whether the current piece can move to a new tile
     * (1 for yes, 0 for no)
     */
    int canMove(int row, int col);

    /**
     * Check if the current piece can move to another tile
     * by making sure that there are no pieces in the way
     * @param board the current chessboard the piece is on
     * @param row an integer representing the destination row coordinate
     * @param col an integer representing the destination column coordinate
     * @return 1 if the current piece can move to a new tile, 0 otherwise
     */
    int canMoveV2(Board board, int row, int col);

    /**
     * Check if the current piece can kill another piece
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current piece can kill another piece
     * (1 for yes, 0 for no)
     */
    int canKill(ChessPiece piece);

    /**
     * Check if the current piece can kill another piece on an active board
     * @param board the Board object, representing an active chessboard
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current piece can kill another piece
     * (1 for yes, 0 for no)
     */
    int canKillV2(Board board, ChessPiece piece);

}
