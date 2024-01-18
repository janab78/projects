public abstract class ChessPiece {

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

    public void printWrongMove(boolean output) {
        if (output) {
            System.out.println("Incorrect move pattern for " + this);
        }
    }
}