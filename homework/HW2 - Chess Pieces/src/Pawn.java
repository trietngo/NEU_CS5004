/**
 * Importing Java Objects Utilities
 */
import java.util.Objects;

/**
 * This class represents a Pawn chess piece. It offers all
 * the operations mandated by the ChessPiece interface.
 * It also extends the abstract class ChessObject and thus
 * inherits all attributes offered by the abstract class.
 */
public class Pawn extends ChessObject implements ChessPiece{

    /**
     * Inherits the attributes from abstract class ChessObject
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public Pawn(int row, int col, Color color) {
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
     * Check if the current Pawn can move to another tile
     * @param row an integer representing the desired row coordinate
     * @param col an integer representing the desired column coordinate
     * @return whether the current Pawn can move to a new tile
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

        // Check for validity

        int rowDiffMove = row - this.getRow();
        int colDiffMove = col - this.getColumn();

        // If a pawn is black
        // Can move one row directly below in the same column
        if (Objects.equals(this.getColor(), "Black")) {
            if (rowDiffMove == -1 && colDiffMove == 0) {
                return 1;
            }
            return 0;
        }

        // If a pawn is white
        // Can move one row directly above in the same column
        if (Objects.equals(this.getColor(), "White")) {
            if (rowDiffMove == 1 && colDiffMove == 0) {
                return 1;
            }
            return 0;
        }

        return 0;
    }

    /**
     * Check if the current Pawn can kill another piece
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current Pawn can kill another piece
     * (1 for yes, 0 for no)
     */
    @Override
    public int canKill(ChessPiece piece) {

        int rowDiffKill = piece.getRow() - this.getRow();
        int colDiffKill = piece.getColumn() - this.getColumn();

        // If a pawn is black and
        // The target is white
        // The target is one row below
        // The target is one column away in either direction
        if (Objects.equals(this.getColor(), "Black")) {
            if (rowDiffKill == -1 &&
                (colDiffKill == 1 || colDiffKill == -1) &&
                (Objects.equals(piece.getColor(), "White"))) {
                return 1;
            }
            return 0;
        }

        // If a pawn is white and
        // The target is black
        // The target is one row above
        // The target is one column away in either direction
        if (Objects.equals(this.getColor(), "White")) {
            if (rowDiffKill == 1 &&
                (colDiffKill == 1 || colDiffKill == -1) &&
                Objects.equals(piece.getColor(), "Black")) {
                return 1;
            }
            return 0;
        }

        return 0;
    }

}

