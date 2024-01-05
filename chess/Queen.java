public class Queen extends ChessPiece {

    public Queen(ChessColor c) {
        super(c);
    }

    public boolean isLegalMove(Move selectedMove) {
        return true;
    }

    public String toString() {
        return "q";
    }
}