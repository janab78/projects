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

    public void placePiece(ChessPiece p) {
        piece = p;
    }

    public void removePiece(ChessPiece p) {
        piece = null;
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