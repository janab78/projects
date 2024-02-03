public class Move {
    Square origin;
    Square destination;
    ChessPiece movingPiece, capturedPiece;
    boolean enPassant, castling, pawnPromotion;
  
    public Move(Square from, Square to) {
        origin = from;
        destination = to;
        movingPiece = from.getPiece();
        capturedPiece = null;
        enPassant = false;
        castling = false;
        pawnPromotion = false;
    }

    public void debug() {
        System.out.println("Move: " + origin.toString() + " " + destination.toString());
        System.out.println("Moving piece: " + movingPiece.toString() + " " + movingPiece.getColor());
        if (capturedPiece != null) {
            System.out.println("Captured piece: " + capturedPiece.toString() + " " + capturedPiece.getColor());
        }
        else {
            System.out.println("Captured piece: null");
        }
    }

    public Square getOrgSquare() {
        return origin;
    }

    public Square getDestSquare() {
        return destination;
    }

    public void setCapturedPiece(ChessPiece cp) {
        capturedPiece = cp;
    }

    public void setMovingPiece(ChessPiece mp) {
        movingPiece = mp;
    }

    public void setEnPassant() {
        enPassant = true;
    }

    public boolean isEnPassant() {
        return enPassant;
    }

    public void setCastling() {
        castling = true;
    }

    public boolean isCastling() {
        return castling;
    }

    public void setPawnPromotion() {
        pawnPromotion = true;
    }

    public boolean isPawnPromotion() {
        return pawnPromotion;
    }

    public ChessPiece getCapturedPiece() {
        return capturedPiece;
    }

    public ChessPiece getMovingPiece() {
        return movingPiece;
    }

    public String toString() {
        return origin + " " + destination;
    }
}