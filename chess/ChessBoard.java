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
                    squares[x][y] = new Square(ChessColor.BLACK);
                }
                else {
                    squares[x][y] = new Square(ChessColor.WHITE);
                }
            }
        }
    }

    private void populateSquares() {
        for (int x = 1; x < 9; x++) {
            squares[x][2].placePiece(new Pawn(ChessColor.WHITE));
            squares[x][7].placePiece(new Pawn(ChessColor.BLACK));
            if (x == 1 || x == 8) {
                squares[x][1].placePiece(new Rook(ChessColor.WHITE));
                squares[x][8].placePiece(new Rook(ChessColor.BLACK));
            }
            if (x == 2 || x == 7) {
                squares[x][1].placePiece(new Knight(ChessColor.WHITE));
                squares[x][8].placePiece(new Knight(ChessColor.BLACK));
            }
            if (x == 3 || x == 6) {
                squares[x][1].placePiece(new Bishop(ChessColor.WHITE));
                squares[x][8].placePiece(new Bishop(ChessColor.BLACK));
            }
            if (x == 4) {
                squares[x][1].placePiece(new Queen(ChessColor.WHITE));
                squares[x][8].placePiece(new Queen(ChessColor.BLACK));
            }
            if (x == 5) {
                squares[x][1].placePiece(new King(ChessColor.WHITE));
                squares[x][8].placePiece(new King(ChessColor.BLACK));
            }
        }
    }

    public void implementMove(Move move) {
        SquarePos orgSquarePos = move.getOrgPos();
        SquarePos destSquarePos = move.getDestPos();
        ChessPiece movingPiece = squares[orgSquarePos.getXPos()][orgSquarePos.getYPos()].removePiece();
        move.setKilledPiece(squares[destSquarePos.getXPos()][destSquarePos.getYPos()].placePiece(movingPiece));
    }

    public ChessPiece getMovingPiece(Move move) {
        SquarePos orgSquarePos = move.getOrgPos();
        return squares[orgSquarePos.getXPos()][orgSquarePos.getYPos()].getPiece();
    }

    public void display() {
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