public class Queen extends ChessPiece {

    public Queen(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (Math.abs(xMovement) == Math.abs(yMovement) || xMovement == 0 && yMovement != 0 || xMovement != 0 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove, output);
        }
        super.printWrongMove(output);
        return false;
    }

    public char getPieceSymbol() {
        return color == ChessColor.BLACK ? '\u2655' : '\u265B';
    }

    public String toString() {
        return "queen";
    }
}