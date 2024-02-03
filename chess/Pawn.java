import java.lang.Math;

public class Pawn extends ChessPiece {

    public Pawn(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        ChessPiece movingPiece = selectedMove.getMovingPiece();
        ChessPiece destPiece = selectedMove.getDestSquare().getPiece();
        int yDirection = 1;
        int startRow = 2;
        if (movingPiece.getColor() == ChessColor.BLACK) {
            yDirection = -1;
            startRow = 7;
        }
        if (selectedMove.getDestSquare().getYPos() == 1 || selectedMove.getDestSquare().getYPos() == 8) {
            selectedMove.setPawnPromotion();
        }
        if (Math.abs(xMovement) == 1 && yMovement == (-1 * yDirection)) {
            if (destPiece != null && destPiece.getColor() == movingPiece.getColor().getOpposite()) {
                return true;
            }
            else { //check en passant
                if (selectedMove.getOrgSquare().getYPos() == startRow + (3 * yDirection)) {
                    Move lastMove = board.getLastMove();
                    if (lastMove.getMovingPiece() instanceof Pawn && 
                        lastMove.getOrgSquare().getYPos() - lastMove.getDestSquare().getYPos() == 2 &&
                        lastMove.getDestSquare().getXPos() == selectedMove.getDestSquare().getXPos()) {
                        selectedMove.setEnPassant();
                        return true;
                    }
                }
            }
        }
        else if (destPiece == null && xMovement == 0 &&
        yMovement == (-2 * yDirection) && selectedMove.getOrgSquare().getYPos() == startRow && 
        board.getPieceAtSquare(selectedMove.getOrgSquare().getXPos(), startRow + yDirection) == null) {
            return true;
        }
        else if (destPiece == null && xMovement == 0 &&
        yMovement == (-1 * yDirection)) {
            return true;
        }
        super.printWrongMove(output);
        return false;
    }

    public String getPieceSymbol() {
        return "p";
    }

    public String toString() {
        return "pawn";
    }
}