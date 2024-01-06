public abstract class ChessPiece {

    ChessColor color;
    ChessBoard board;

    public ChessPiece(ChessColor c, ChessBoard b) {
        color = c;
        board = b;
    }

    public abstract boolean isLegalMove(Move selectedMove);

    public ChessColor getColor() {
        return color;
    }
}