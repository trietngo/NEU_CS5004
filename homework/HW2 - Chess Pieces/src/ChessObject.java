/**
 * This abstract class represents any chess piece. It offers all
 * the attributes that can be inherited by a specific class of
 * chess piece.
 */
public abstract class ChessObject implements ChessPiece {
    public int row;
    public int col;
    public Color color;

    /**
     * Construct a chess piece
     * @param row integer between 0 and 7
     * @param col integer between 0 and 7
     * @param color an instance of Color enum class
     */
    public ChessObject(int row, int col, Color color) {
        if ((row < 0 || row > 7) || (col < 0 || col > 7)) {
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.col = col;
        this.color = color;
    }

}
