/**
 * This interface contains all operations that all types of chessboard
 * should support.
 */
public interface ChessBoard {

    /**
     * The function returns the piece at the input coordinates
     * @param row the integer row coordinate
     * @param col the integer column coordinate
     * @return the chess piece at the input coordinates
     */
    ChessPiece getPiece(int row, int col);

    /**
     * The function sets a chess piece on the board
     * @param piece a chess piece
     * @param row the target integer row coordinate
     * @param col the target integer column coordinate
     */
    ChessPiece setPiece(ChessPiece piece, int row, int col);

}
