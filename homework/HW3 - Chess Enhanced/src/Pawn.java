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
     * Construct a Pawn piece with row-col coordinates and color
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public Pawn(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Inherits the attributes from abstract class ChessObject
     * Construct a Pawn piece with its color only
     * @param color an instance of Color enum class
     */
    public Pawn(Color color) {
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

        // Check for validity

        int rowDiffMove = row - this.row;
        int colDiffMove = col - this.col;

        // If a pawn is black
        // Can move one row directly below in the same column
        if (Objects.equals(this.getColor(), "Black")) {
            if (rowDiffMove == -1 && colDiffMove == 0 &&
                board.getPiece(row, col) == null) {
                return 1;
            }
            return 0;
        }

        // If a pawn is white
        // Can move one row directly above in the same column
        if (Objects.equals(this.getColor(), "White")) {
            if (rowDiffMove == 1 && colDiffMove == 0 &&
                board.getPiece(row, col) == null) {
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

        int rowDiffKill = piece.getRow() - this.row;
        int colDiffKill = piece.getColumn() - this.col;

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

    /**
     * Check if the current Pawn can kill another piece on an active board
     * @param board the Board object, representing an active chessboard
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current piece can kill another piece (1 for yes, 0 for no)
     */
    @Override
    public int canKillV2(Board board, ChessPiece piece) {
        int rowDiffKill = piece.getRow() - this.row;
        int colDiffKill = piece.getColumn() - this.col;

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

