public abstract class ChessPiece {

    ChessColor color;

    public ChessPiece(ChessColor c) {
        color = c;
    }

    public abstract boolean isLegalMove(Move selectedMove);

    public ChessColor getColor() {
        return color;
    }
}