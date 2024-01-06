public class ChessBoard {

    Square[][] squares;

    public ChessBoard() {
        squares = new Square[9][9];
        createSquares();
        populateSquares();
    }

    private void createSquares() {
        for (int x = 1; x < 9; x++) {
            for (int y = 1; y < 9; y++) {
                if (x % 2 == y % 2) {
                    squares[x][y] = new Square(ChessColor.BLACK, x, y);
                }
                else {
                    squares[x][y] = new Square(ChessColor.WHITE, x, y);
                }
            }
        }
    }

    private void populateSquares() {
        for (int x = 1; x < 9; x++) {
            squares[x][2].placePiece(new Pawn(ChessColor.WHITE, this));
            squares[x][7].placePiece(new Pawn(ChessColor.BLACK, this));
            if (x == 1 || x == 8) {
                squares[x][1].placePiece(new Rook(ChessColor.WHITE, this));
                squares[x][8].placePiece(new Rook(ChessColor.BLACK, this));
            }
            if (x == 2 || x == 7) {
                squares[x][1].placePiece(new Knight(ChessColor.WHITE, this));
                squares[x][8].placePiece(new Knight(ChessColor.BLACK, this));
            }
            if (x == 3 || x == 6) {
                squares[x][1].placePiece(new Bishop(ChessColor.WHITE, this));
                squares[x][8].placePiece(new Bishop(ChessColor.BLACK, this));
            }
            if (x == 4) {
                squares[x][1].placePiece(new Queen(ChessColor.WHITE, this));
                squares[x][8].placePiece(new Queen(ChessColor.BLACK, this));
            }
            if (x == 5) {
                squares[x][1].placePiece(new King(ChessColor.WHITE, this));
                squares[x][8].placePiece(new King(ChessColor.BLACK, this));
            }
        }
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    public ChessPiece getPieceAtSquare(int x, int y) {
        return squares[x][y].getPiece();
    }

    public void implementMove(Move move) {
        move.setKilledPiece(move.getDestSquare().removePiece());
        move.getDestSquare().placePiece(move.getMovingPiece());
        move.getOrgSquare().removePiece();
    }

    public boolean isPathUnblocked(Move move) {
        int xMovement = 0;
        int yMovement = 0;
        int x = move.getOrgSquare().getXPos();
        int y = move.getOrgSquare().getYPos();
        int destXPos = move.getDestSquare().getXPos();
        int destYPos = move.getDestSquare().getYPos();
        if (x < destXPos) {
            xMovement = 1;
        }
        else if (x > destXPos) {
            xMovement = -1;
        }
        if (y < destYPos) {
            yMovement = 1;
        }
        else if (y > destYPos) {
            yMovement = -1;
        }

        do {
            x = x + xMovement;
            y = y + yMovement;
            if (x == destXPos && y == destYPos && squares[x][y].isOccupied() && squares[x][y].getPiece().getColor() == move.getMovingPiece().getColor()) {
                return false;
            }
            if ((x != destXPos || y != destYPos) && squares[x][y].isOccupied()) {
                return false;
            }
        } while (x != destXPos && y != destYPos);
        return true;
    }

    public void display() {
        System.out.println();
        for (int y = 8; y > 0; y--) {
            System.out.print(" " + y + "   ");
            for (int x = 1; x < 9; x++) {
                System.out.print(squares[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("     ");
        for (int letter = 65; letter < 73; letter++) {
            System.out.print((char)(letter) + " ");
        }
        System.out.println();
    }
}