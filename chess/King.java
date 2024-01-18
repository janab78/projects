public class King extends ChessPiece {

    public King(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (Math.abs(xMovement) == 1 && Math.abs(yMovement) == 1 || xMovement == 0 && Math.abs(yMovement) == 1 || Math.abs(xMovement) == 1 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove, output);
        }
        super.printWrongMove(output);
        return false;
    }

    public String getPieceSymbol() {
        return "k";
    }

    public String toString() {
        return "king";
    }
}