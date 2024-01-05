public class Square {
    ChessColor color;
    ChessPiece piece;

    public Square (ChessColor c) {
        color = c;
        piece = null;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public ChessColor hasColor() {
        return color;
    }

    public ChessPiece placePiece(ChessPiece p) {
        ChessPiece killedPiece = piece;
        piece = p;
        return killedPiece;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public ChessPiece removePiece() {
        ChessPiece removedPiece = piece;
        piece = null;
        return removedPiece;
    }

    public String toString() {
        if (piece == null) {
            return " ";
        }
        if (piece.getColor() == ChessColor.WHITE) {
            return piece.toString().toUpperCase();
        }
        else {
            return piece.toString();
        }
    }
}