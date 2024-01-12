public class Knight extends ChessPiece {

    public Knight(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        boolean destEmptyOrEnemy = true;
        if (selectedMove.getDestSquare().getPiece() != null) {
            destEmptyOrEnemy = selectedMove.movingPiece.getColor() != selectedMove.getDestSquare().getPiece().getColor();
        }
        if ((Math.abs(xMovement) == 1 && Math.abs(yMovement) == 2 || Math.abs(xMovement) == 2 && Math.abs(yMovement) == 1) && destEmptyOrEnemy) {
            return true;
        }
        else if (destEmptyOrEnemy == false) {
            System.out.println("You cannot capture your own piece");
            return false;
        }
        super.printWrongMove();
        return false;
    }

    public String getPieceSymbol() {
        return "n";
    }

    public String toString() {
        return "knight";
    }
}