public class Move {
    Square origin;
    Square destination;
    ChessPiece movingPiece, killedPiece;
  
    public Move(Square from, Square to) {
        origin = from;
        destination = to;
        movingPiece = from.getPiece();
        killedPiece = null;
    }

    public Square getOrgSquare() {
        return origin;
    }

    public Square getDestSquare() {
        return destination;
    }

    public void setKilledPiece(ChessPiece kp) {
        killedPiece = kp;
    }

    public void setMovingPiece(ChessPiece mp) {
        movingPiece = mp;
    }

    public ChessPiece getKilledPiece() {
        return killedPiece;
    }

    public ChessPiece getMovingPiece() {
        return movingPiece;
    }
}