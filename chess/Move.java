public class Move {
    SquarePos origin;
    SquarePos destination;
    ChessPiece movingPiece, killedPiece;
  
    public Move(SquarePos from, SquarePos to) {
        origin = from;
        destination = to;
        movingPiece = null;
        killedPiece = null;
    }

    public SquarePos getOrgPos() {
        return origin;
    }

    public SquarePos getDestPos() {
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