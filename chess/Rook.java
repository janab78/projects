public class Rook extends ChessPiece {

    public Rook(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (xMovement == 0 && yMovement != 0 || xMovement != 0 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove);
        }
        return false;
    }

    public String toString() {
        return "r";
    }
}
