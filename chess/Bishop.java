import java.lang.Math;

public class Bishop extends ChessPiece {

    public Bishop(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (Math.abs(xMovement) == Math.abs(yMovement)) {
            return board.isPathUnblocked(selectedMove, output);
        }
        super.printWrongMove(output);
        return false;
    }

    public char getPieceSymbol() {
        return color == ChessColor.BLACK ? '\u2657' : '\u265D';
    }

    public String toString() {
        return "bishop";
    }
}