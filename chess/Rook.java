public class Rook extends ChessPiece {

    public Rook(ChessColor c) {
        super(c);
    }

    public boolean isLegalMove(Move selectedMove) {
        return true;
    }

    public String toString() {
        return "r";
    }
}
