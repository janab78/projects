import java.util.ArrayList;

public abstract class ChessPiece {

    ArrayList<Move> allMoves = new ArrayList<>();
    ChessColor color;
    ChessBoard board;
    Square square;
    boolean captured;

    public ChessPiece(ChessColor c, ChessBoard b) {
        color = c;
        board = b;
        captured = false;
    }

    public abstract boolean isLegalMove(Move selectedMove, boolean output);

    public abstract String getPieceSymbol();

    public ChessColor getColor() {
        return color;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured() {
        captured = true;
    }

    public void setNotCaptured() {
        captured = false;
    }

    public void setSquare(Square s) {
        square = s;
    }

    public Square getSquare() {
        return square;
    }

    public void addMove(Move move) {
        allMoves.add(move);
    }

    public void removeMove (Move move) {
        allMoves.remove(move);
    }

    public int getNrOfMoves() {
        return allMoves.size();
    }

    public void printWrongMove(boolean output) {
        if (output) {
            System.out.println("Incorrect move pattern for " + this);
        }
    }

    public void setCheck() {
    }

    public void setNotCheck() {
    }

    public boolean isInCheck() {
        return false;
    }
}