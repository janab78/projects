public class Bishop extends ChessPiece {

    public Bishop(ChessColor c) {
        super(c);
    }

    public boolean isLegalMove(Move selectedMove) {
        return true;
    }

    public String toString() {
        return "b";
    }
}