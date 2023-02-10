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
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public King(int row, int col, Color color) {
        super(row, col, color);
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

}
