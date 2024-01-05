public class Knight extends ChessPiece {

    public Knight(ChessColor c) {
        super(c);
    }

    public boolean isLegalMove(Move selectedMove) {
        return true;
    }

    public String toString() {
        return "n";
    }
}