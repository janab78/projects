public class Pawn extends ChessPiece {

    public Pawn(ChessColor c) {
        super(c);
    }

    public boolean isLegalMove(Move selectedMove) {
        return true;
    }

    public String toString() {
        return "p";
    }
}