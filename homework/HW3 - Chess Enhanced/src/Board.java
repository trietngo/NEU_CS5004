/**
 * Import Java's ArrayList utility
 */
import java.util.ArrayList;

/**
 * This class represents a 8x8 chess board. It offers all
 * the operations mandated by the ChessBoard interface.
 */
public class Board implements ChessBoard{
    private ArrayList<ArrayList<ChessPiece>> chessBoardList;
    public static int SIZE = 8;

    /**
     * Constructs an empty board as an array list with
     * all empty tiles represented as "null"
     */
    public Board() {

        chessBoardList = new ArrayList<ArrayList<ChessPiece>>();

        for (int i = 0; i < SIZE; i++) {

            ArrayList<ChessPiece> row = new ArrayList<ChessPiece>();
            chessBoardList.add(row);

            for (int j = 0; j < SIZE; j++) {
                row.add(null);
            }
        }
    }

    /**
     * Put a chess piece on the board at a specific coordinate
     * and set that chess piece's coordinates accordingly.
     * @throws IllegalArgumentException if the input coordinates are out of bounds
     * @throws IllegalArgumentException if there is already a piece at the coordinate
     * @param piece the ChessPiece object, any chess piece
     * @param row integer row coordinate
     * @param col integer column coordinate
     * @return the ChessPiece object with updated coordinates
     */
    @Override
    public ChessPiece setPiece(ChessPiece piece, int row, int col) {

        if (chessBoardList.get(row).get(col) != null) {
            throw new IllegalArgumentException("Coordinates occupied.");
        }

        if (row > 7 || col > 7 || row < 0 || col < 0){
            throw new IllegalArgumentException("Selected coordinates out of bounds.");
        }

        piece.setRow(row);
        piece.setColumn(col);

        chessBoardList.get(row).set(col, piece);
        return piece;
    }

    /**
     * Get the chess piece at the specified coordinates
     * @throws IllegalArgumentException if the input coordinates are out of bounds
     * @param row the integer row coordinate
     * @param col the integer column coordinate
     * @return the ChessPiece object at the input coordinates
     */
    @Override
    public ChessPiece getPiece(int row, int col) {
        if (row > 7 || col > 7 || row < 0 || col < 0){
            throw new IllegalArgumentException("Selected coordinates out of bounds.");
        }
        return chessBoardList.get(row).get(col);
    }

}
