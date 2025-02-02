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
        ChessPiece capturedPiece = piece;
        piece = p;
        if (piece != null) {
            piece.setSquare(this);
        }
        return capturedPiece;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public ChessPiece removePiece() {
        ChessPiece removedPiece = piece;
        piece = null;
        return removedPiece;
    }

    public char getPieceSymbol() {
        if (piece == null) {
            return ' ';
        }
        if (piece.getColor() == ChessColor.WHITE) {
            return piece.getPieceSymbol();
        }
        else {
            return piece.getPieceSymbol();
        }
    }

    public String toString() {
        return "" + (char)(xPos + 64) + yPos;
    }
}