public abstract class ChessPiece {

    ChessColor color;

    public ChessPiece(ChessColor c) {
        color = c;
    }

    public ChessColor getColor() {
        return color;
    }
}