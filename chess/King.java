public class King extends ChessPiece {
    boolean inCheck;

    public King(ChessColor c, ChessBoard b) {
        super(c, b);
        inCheck = false;
    }

    @Override
    public boolean isLegalMove(Move selectedMove, boolean output) {
        int xMovement = selectedMove.getDestSquare().getXPos() - selectedMove.getOrgSquare().getXPos();
        int yMovement = selectedMove.getDestSquare().getYPos() - selectedMove.getOrgSquare().getYPos();
        if (Math.abs(xMovement) == 1 && Math.abs(yMovement) == 1 || xMovement == 0 && Math.abs(yMovement) == 1 || Math.abs(xMovement) == 1 && yMovement == 0) {
            return board.isPathUnblocked(selectedMove, output);
        }
        if (Math.abs(xMovement) == 2 && Math.abs(yMovement) == 0) { // check castling
            ChessPiece rook;
            int rookXDest;
            if (xMovement == 2) {
                rook = board.getPieceAtSquare(8, square.getYPos());
                rookXDest = 6;
            }
            else {
                rook = board.getPieceAtSquare(1, square.getYPos());
                rookXDest = 4;
            }
            Move rookMove = new Move(rook.getSquare(), board.getSquare(rookXDest, square.getYPos()));
            if (getNrOfMoves() == 0 && rook.getNrOfMoves() == 0 && board.isPathUnblocked(rookMove, false) && 
                board.isPathUnblocked(selectedMove, false) && !(inCheck)) {
                    Move firstStep = new Move(square, board.getSquare(square.getXPos() + (xMovement / 2), square.getYPos()));
                    board.implementMove(firstStep);
                    if (board.piecesCheckingKing(this.getColor()).size() == 0) {
                        board.revertMove(firstStep);
                        selectedMove.setCastling();
                        return true;
                    }
                    else {
                        board.revertMove(firstStep);
                    }
                }
        }
        super.printWrongMove(output);
        return false;
    }

    @Override
    public void setCheck() {
        inCheck = true;
    }
    @Override
    public void setNotCheck() {
        inCheck = false;
    }
    @Override
    public boolean isInCheck() {
        return inCheck;
    }

    public String getPieceSymbol() {
        return "k";
    }

    public String toString() {
        return "king";
    }
}