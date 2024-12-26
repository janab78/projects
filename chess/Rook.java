public class Rook extends ChessPiece {

    public Rook(ChessColor c, ChessBoard b) {
        super(c, b);
    }

    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getOrgSquare().getXPos() - selectedMove.getDestSquare().getXPos();
        int yMovement = selectedMove.getOrgSquare().getYPos() - selectedMove.getDestSquare().getYPos();
        if (xMovement == 0 && yMovement != 0 || xMovement != 0 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove, output);
        }
        super.printWrongMove(output);
        return false;
    }

    public char getPieceSymbol() {
        return color == ChessColor.BLACK ? '\u2656' : '\u265C';
    }

    public String toString() {
        return "rook";
    }
}
