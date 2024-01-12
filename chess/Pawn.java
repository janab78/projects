import java.lang.Math;

public class Pawn extends ChessPiece {

    public Pawn(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        ChessPiece movingPiece = selectedMove.getMovingPiece();
        ChessPiece destPiece = selectedMove.getDestSquare().getPiece();
        if (movingPiece.getColor() == ChessColor.WHITE) {
            if (destPiece != null && destPiece.getColor() == ChessColor.BLACK && 
            Math.abs(xMovement) == 1 && yMovement == -1) {
                return true;
            }
            else if (destPiece == null && xMovement == 0 &&
            yMovement == -2 && selectedMove.getOrgSquare().getYPos() == 2) {
                return true;
            }
            else if (destPiece == null && xMovement == 0 &&
            yMovement == -1) {
                return true;
            }
        }
        if (movingPiece.getColor() == ChessColor.BLACK) {
            if (destPiece != null && destPiece.getColor() == ChessColor.WHITE && 
            Math.abs(xMovement) == 1 && yMovement == 1) {
                return true;
            }
            else if (destPiece == null && xMovement == 0 &&
            yMovement == 2 && selectedMove.getOrgSquare().getYPos() == 7 && board.getPieceAtSquare(selectedMove.getOrgSquare().getXPos(), 6) == null) {
                return true;
            }
            else if (destPiece == null && xMovement == 0 &&
            yMovement == 1) {
                return true;
            }
        }
        super.printWrongMove();
        return false;
    }

    public String getPieceSymbol() {
        return "p";
    }

    public String toString() {
        return "pawn";
    }
}