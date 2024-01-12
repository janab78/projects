public class Square {
    ChessColor color;
    ChessPiece piece;
    int xPos, yPos;

    public Square (ChessColor c, int x, int y) {
        color = c;
        piece = null;
        xPos = x;
        yPos = y;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
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

    public String getPieceSymbol() {
        if (piece == null) {
            return " ";
        }
        if (piece.getColor() == ChessColor.WHITE) {
            return piece.getPieceSymbol().toUpperCase();
        }
        else {
            return piece.getPieceSymbol();
        }
    }

    public String toString() {
        return "" + (char)(xPos + 64) + yPos;
    }
}