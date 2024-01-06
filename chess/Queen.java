public class Queen extends ChessPiece {

    public Queen(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (Math.abs(xMovement) == Math.abs(yMovement) || xMovement == 0 && yMovement != 0 || xMovement != 0 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove);
        }
        return false;
    }

    public String toString() {
        return "q";
    }
}