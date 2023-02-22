/**
 * Importing Java Objects Utilities
 */
import java.util.Objects;

/**
 * This class represents a King chess piece. It offers all
 * the operations mandated by the ChessPiece interface.
 * It also extends the abstract class ChessObject and thus
 * inherits all attributes offered by the abstract class.
 */
public class King extends ChessObject implements ChessPiece{

    /**
     * Inherits the attributes from abstract class ChessObject
     * Construct a King piece with row-col coordinates and color
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public King(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Inherits the attributes from abstract class ChessObject
     * Construct a King piece with its color only
     * @param color an instance of Color enum class
     */
    public King(Color color) {
        super(color);
    }

    /**
     * The function returns the row coordinate
     * @return the row coordinate
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * The function returns the column coordinate
     * @return the column coordinate
     */
    @Override
    public int getColumn() {
        return this.col;
    }

    /**
     * The function sets the row coordinate of a chess piece
     *
     * @param row an integer represent the new row coordinate
     * @return the new row coordinate of a chess piece
     */
    @Override
    public int setRow(int row) {
        this.row = row;
        return this.row;
    }

    /**
     * The function sets the column coordinate of a chess piece
     *
     * @param col an integer represent the new column coordinate
     * @return the new row coordinate of a chess piece
     */
    @Override
    public int setColumn(int col) {
        this.col = col;
        return this.col;
    }

    /**
     * The function returns the color of a chess piece
     * @return the string form of the color of a chess piece, White or Black
     */
    @Override
    public String getColor() {
        if (this.color == Color.WHITE) {
            return "White";
        }
        else {
            return "Black";
        }
    }

    /**
     * Check if the current King can move to another tile
     * @param row an integer representing the desired row coordinate
     * @param col an integer representing the desired column coordinate
     * @return whether the current King can move to a new tile
     * (1 for yes, 0 for no)
     */
    @Override
    public int canMove(int row, int col) {

        // Check if the coordinates are within bounds
        if ((row < 0 || row > 7) || (col < 0 || col > 7)) {
            throw new IllegalArgumentException();
        }

        // A piece cannot move to itself
        if ((this.getRow() == row) && (this.getColumn() == col)) {
            throw new IllegalArgumentException();
        }

        // Get the difference between current pos and input pos
        // and check for validity
        int rowDiff = this.getRow() - row;
        int colDiff = this.getColumn() - col;

        if ((rowDiff > 1 || rowDiff < -1) ||
            (colDiff > 1 || colDiff < -1)) {
            return 0;
        }
        return 1;
    }

    /**
     * Check if the current piece can move to another tile by making sure that there are no pieces
     * in the way
     * @param board the current chessboard the piece is on
     * @param row   an integer representing the destination row coordinate
     * @param col   an integer representing the destination column coordinate
     * @return 1 if the current piece can move to a new tile, 0 otherwise
     */
    @Override
    public int canMoveV2(Board board, int row, int col) {
        // Check if the coordinates are within bounds
        if ((row < 0 || row > 7) || (col < 0 || col > 7)) {
            throw new IllegalArgumentException();
        }

        // A piece cannot move to itself
        if ((this.getRow() == row) && (this.getColumn() == col)) {
            throw new IllegalArgumentException();
        }

        // Get the difference between current pos and input pos
        // and check for validity
        int rowDiff = this.getRow() - row;
        int colDiff = this.getColumn() - col;

        if ((rowDiff > 1 || rowDiff < -1) ||
            (colDiff > 1 || colDiff < -1)) {
            return 0;
        }

        // If there is another chess piece at the destination
        // the king cannot move

        if (board.getPiece(row, col) != null) {
            return 0;
        }

        return 1;
    }

    /**
     * Check if the current King can kill another piece
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current King can kill another piece
     * (1 for yes, 0 for no)
     */
    @Override
    public int canKill(ChessPiece piece) {

        // If the current piece can move to the other piece with a different color
        // then the current piece can kill
        if (this.canMove(piece.getRow(), piece.getColumn()) != 1 ||
            Objects.equals(this.getColor(), piece.getColor())) {
            return 0;
        }
        return 1;
    }

    /**
     * Check if the current King can kill another piece on an active board
     * @param board the Board object, representing an active chessboard
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current piece can kill another piece (1 for yes, 0 for no)
     */
    @Override
    public int canKillV2(Board board, ChessPiece piece) {

        // Check if the targets are within bounds
        if ((piece.getRow() < 0 || piece.getRow() > 7) ||
            (piece.getColumn() < 0 || piece.getColumn() > 7)) {
            throw new IllegalArgumentException();
        }

        // A piece cannot kill at current position
        if ((this.row == piece.getRow()) && (this.col == piece.getColumn())) {
            throw new IllegalArgumentException();
        }

        // Get the difference between current pos and target pos
        // and check for validity
        int rowDiff = this.getRow() - piece.getRow();
        int colDiff = this.getColumn() - piece.getColumn();

        if ((rowDiff > 1 || rowDiff < -1) ||
            (colDiff > 1 || colDiff < -1)) {
            return 0;
        }

        // Check if friend or foe
        if (!Objects.equals(this.getColor(), piece.getColor())) {
            return 1;
        }
        return 0;
    }

}
