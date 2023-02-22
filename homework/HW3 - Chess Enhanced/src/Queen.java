/**
 * Importing Java Objects Utilities
 */
import java.util.Objects;

/**
 * This class represents a Queen chess piece. It offers all
 * the operations mandated by the ChessPiece interface.
 * It also extends the abstract class ChessObject and thus
 * inherits all attributes offered by the abstract class.
 */
public class Queen extends ChessObject implements ChessPiece{

    /**
     * Inherits the attributes from abstract class ChessObject
     * Construct a Queen piece with row-col coordinates and color
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public Queen(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Inherits the attributes from abstract class ChessObject
     * Construct a Bishop piece with its color only
     * @param color an instance of Color enum class
     */
    public Queen(Color color) {
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
        return this.row;
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
     * Check if the current Queen can move to another tile
     * @param row an integer representing the desired row coordinate
     * @param col an integer representing the desired column coordinate
     * @return whether the current Queen can move to a new tile
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

        // Move horizontally and vertically
        if (this.getRow() == row || this.getColumn() == col) {
            return 1;
        }

        // Move diagonally along SW-NE axis
        int coordDiffThis = this.getRow() - this.getColumn();
        int coordDiffTarget = row - col;

        // Move diagonally along SE-NW axis
        int coordTotalThis = this.getRow() + this.getColumn();
        int coordTotalTarget = row + col;

        if (coordDiffThis == coordDiffTarget ||
            coordTotalThis == coordTotalTarget) {
            return 1;
        }

        return 0;
    }

    /**
     * Check if the current piece can move to another tile by making sure
     * that there are no pieces in the way
     * A Queen can move in all 8 cardinal directions: N, S, E, W, NE, SW, NW, SE
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

        // VERTICAL MOVEMENTS
        // Go North
        if (col == this.col && row > this.row) {
            // Go through all tiles north of current piece
            for (int i = this.row + 1; i <= row; i++) {
                ChessPiece obstaclePiece = board.getPiece(i, this.col);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // Go South
        if (col == this.col && row < this.row) {
            // Go through all tiles south of current piece
            for (int i = this.row - 1; i >= row; i--) {
                ChessPiece obstaclePiece = board.getPiece(i, this.col);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // HORIZONTAL MOVEMENTS
        // Go East
        if (row == this.row && col > this.col) {
            // Go through all tiles east of current piece
            for (int i = this.col + 1; i <= col; i++) {
                ChessPiece obstaclePiece = board.getPiece(this.row, i);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // Go West
        if (row == this.row && col < this.col) {
            // Go through all tiles west of current piece
            for (int i = this.col - 1; i >= col; i--) {
                ChessPiece obstaclePiece = board.getPiece(this.row, i);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // DIAGONAL MOVEMENTS

        // Move diagonally along SW-NE axis
        int coordDiffThis = this.getRow() - this.getColumn();
        int coordDiffTarget = row - col;

        // Move NE
        if (coordDiffThis == coordDiffTarget &&
            row > this.row && col > this.col) {
            // Go through all tiles NE of current piece
            for (int i = this.row + 1, j = this.col + 1; i <= row && j <= col; i++, j++) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // Move SW
        if (coordDiffThis == coordDiffTarget &&
            row < this.row && col < this.col) {
            // Go through all tiles SW of current piece
            for (int i = this.row - 1, j = this.col - 1; i >= row && j >= col; i--, j--) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // Move diagonally along SE-NW axis
        int coordTotalThis = this.getRow() + this.getColumn();
        int coordTotalTarget = row + col;

        // Move SE
        if (coordTotalThis == coordTotalTarget &&
            row < this.row && col > this.col) {

            // Go through all tiles SE of current piece
            for (int i = this.row - 1, j = this.col + 1; i >= row && j <= col; i--, j++) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }

        // Move NW
        if (coordTotalThis == coordTotalTarget &&
            row > this.row && col < this.col) {

            // Go through all tiles SE of current piece
            for (int i = this.row + 1, j = this.col - 1; i <= row && j >= col; i++, j--) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    return 0;
                }
            }
            return 1;
        }
        return 0;
    }

    /**
     * Check if the current Queen can kill another piece
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current Queen can kill another piece
     * (1 for yes, 0 for no)
     */
    @Override
    public int canKill(ChessPiece piece) {

        // If the current piece can move to the other piece
        // with a different color then the current piece can kill
        if (this.canMove(piece.getRow(), piece.getColumn()) != 1 ||
            Objects.equals(this.getColor(), piece.getColor())) {
            return 0;
        }
        return 1;
    }

    /**
     * Check if the current Queen can kill another piece on an active board
     * Based on canMoveV2, if there is an opposing piece at the destination
     * and the current piece encounters only 1 obstacle, then
     * the current piece can kill another piece
     * @param board the Board object, representing an active chessboard
     * @param piece another ChessPiece object with its own coordinates
     * @return whether the current piece can kill another piece (1 for yes, 0 for no)
     */
    @Override
    public int canKillV2(Board board, ChessPiece piece) {
        // Check if the coordinates are within bounds
        if ((piece.getRow() < 0 || piece.getRow() > 7) ||
            (piece.getColumn() < 0 || piece.getColumn() > 7)) {
            throw new IllegalArgumentException();
        }

        // A piece cannot kill at current position
        if ((this.row == piece.getRow()) && (this.col == piece.getColumn())) {
            throw new IllegalArgumentException();
        }

        // Check for validity

        // Initialize the number of obstacles between the current
        // Queen to its destination
        int obstacleCount = 0;

        // VERTICAL MOVEMENTS
        // Go North
        if (piece.getColumn() == this.col && piece.getRow() > this.row) {
            // Go through all tiles north of current piece
            for (int i = this.row + 1; i <= piece.getRow(); i++) {
                ChessPiece obstaclePiece = board.getPiece(i, this.col);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }

            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // Go South
        if (piece.getColumn() == this.col && piece.getRow() < this.row) {
            // Go through all tiles south of current piece
            for (int i = this.row - 1; i >= piece.getRow(); i--) {
                ChessPiece obstaclePiece = board.getPiece(i, this.col);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // HORIZONTAL MOVEMENTS
        // Go East
        if (piece.getRow() == this.row && piece.getColumn() > this.col) {
            // Go through all tiles east of current piece
            for (int i = this.col + 1; i <= piece.getColumn(); i++) {
                ChessPiece obstaclePiece = board.getPiece(this.row, i);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // Go West
        if (piece.getRow() == this.row && piece.getColumn() < this.col) {
            // Go through all tiles west of current piece
            for (int i = this.col - 1; i >= piece.getColumn(); i--) {
                ChessPiece obstaclePiece = board.getPiece(this.row, i);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // DIAGONAL MOVEMENTS

        // Move diagonally along SW-NE axis
        int coordDiffThis = this.getRow() - this.getColumn();
        int coordDiffTarget = piece.getRow() - piece.getColumn();

        // Move NE
        if (coordDiffThis == coordDiffTarget &&
            piece.getRow() > this.row && piece.getColumn() > this.col) {
            // Go through all tiles NE of current piece
            for (int i = this.row + 1, j = this.col + 1;
                i <= piece.getRow() && j <= piece.getColumn(); i++, j++) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // Move SW
        if (coordDiffThis == coordDiffTarget &&
            piece.getRow() < this.row && piece.getColumn() < this.col) {
            // Go through all tiles SW of current piece
            for (int i = this.row - 1, j = this.col - 1;
                i >= piece.getRow() && j >= piece.getColumn(); i--, j--) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // Move diagonally along SE-NW axis
        int coordTotalThis = this.getRow() + this.getColumn();
        int coordTotalTarget = piece.getRow() + piece.getColumn();

        // Move SE
        if (coordTotalThis == coordTotalTarget &&
            piece.getRow() < this.row && piece.getColumn() > this.col) {

            // Go through all tiles SE of current piece
            for (int i = this.row - 1, j = this.col + 1;
                i >= piece.getRow() && j <= piece.getColumn(); i--, j++) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }

        // Move NW
        if (coordTotalThis == coordTotalTarget &&
            piece.getRow() > this.row && piece.getColumn() < this.col) {

            // Go through all tiles SE of current piece
            for (int i = this.row + 1, j = this.col - 1;
                i <= piece.getRow() && j >= piece.getColumn(); i++, j--) {
                ChessPiece obstaclePiece = board.getPiece(i, j);

                // Check for blocking piece
                if (obstaclePiece != null) {
                    obstacleCount++;
                }
            }
            if (obstacleCount == 1 &&
                !Objects.equals(this.getColor(), piece.getColor())) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

}
