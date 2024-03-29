import java.util.HashMap;
import java.util.ArrayList;

public class ChessBoard {

    Square[][] squares;
    HashMap<ChessColor, ChessPiece> kings;
    HashMap<ChessColor, ArrayList<ChessPiece>> allOtherPieces;
    ArrayList<Move> allMoves;


    public ChessBoard() {
        kings = new HashMap<>();
        allOtherPieces = new HashMap<>();
        allOtherPieces.put(ChessColor.WHITE, new ArrayList<>());
        allOtherPieces.put(ChessColor.BLACK, new ArrayList<>());
        squares = new Square[9][9];
        allMoves = new ArrayList<>();
        createSquares();
        createAndPlacePieces();
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

    private void createAndPlacePieces() {
        for (int x = 1; x < 9; x++) {
            storeAndPlacePiece(new Pawn(ChessColor.WHITE, this), x, 2);
            storeAndPlacePiece(new Pawn(ChessColor.BLACK, this), x, 7);
            if (x == 1 || x == 8) {
                storeAndPlacePiece(new Rook(ChessColor.WHITE, this), x, 1);
                storeAndPlacePiece(new Rook(ChessColor.BLACK, this), x, 8);
            }
            if (x == 2 || x == 7) {
                storeAndPlacePiece(new Knight(ChessColor.WHITE, this), x, 1);
                storeAndPlacePiece(new Knight(ChessColor.BLACK, this), x, 8);
            }
            if (x == 3 || x == 6) {
                storeAndPlacePiece(new Bishop(ChessColor.WHITE, this), x, 1);
                storeAndPlacePiece(new Bishop(ChessColor.BLACK, this), x, 8);
            }
            if (x == 4) {                
                storeAndPlacePiece(new Queen(ChessColor.WHITE, this), x, 1);
                storeAndPlacePiece(new Queen(ChessColor.BLACK, this), x, 8);
            }
            if (x == 5) {
                ChessPiece newWhiteKing = new King(ChessColor.WHITE, this);
                squares[x][1].placePiece(newWhiteKing);
                kings.put(ChessColor.WHITE, newWhiteKing);                
                ChessPiece newBlackKing = new King(ChessColor.BLACK, this);
                squares[x][8].placePiece(newBlackKing);                
                kings.put(ChessColor.BLACK, newBlackKing);
            }
        }
    }

    private void storeAndPlacePiece(ChessPiece p, int x, int y) {
        squares[x][y].placePiece(p);
        allOtherPieces.get(p.getColor()).add(p);  
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    public ChessPiece getPieceAtSquare(int x, int y) {
        return squares[x][y].getPiece();
    }

    public ChessPiece removePieceAtSquare(int x, int y) {
    return squares[x][y].removePiece();
    }

    public Move getLastMove() {
        return allMoves.get(allMoves.size()-1);
    }

    public void implementMove(Move move) {
        ChessPiece capturedPiece = null;
        if (move.isEnPassant()) {
            Move lastMove = getLastMove();
            capturedPiece = lastMove.getDestSquare().removePiece();
        }
        if (move.isCastling()) {
            int xMovement = move.getDestSquare().getXPos() - move.getOrgSquare().getXPos();
            ChessPiece rook;
            int rookXDest;
            if (xMovement == 2) {
                rook = removePieceAtSquare(8, move.getDestSquare().getYPos());
                rookXDest = 6;
            }
            else {
                rook = removePieceAtSquare(1, move.getDestSquare().getYPos());
                rookXDest = 4;
            }
            move.getDestSquare().placePiece(move.getMovingPiece());
            move.getOrgSquare().removePiece();
            getSquare(rookXDest, move.getOrgSquare().getYPos()).placePiece(rook);
        }
        if (move.isPawnPromotion()) {
            move.getMovingPiece().setCaptured();
            capturedPiece = move.getMovingPiece();
            ChessPiece newQueen = new Queen(move.getMovingPiece().getColor(), this);
            allOtherPieces.get(newQueen.getColor()).add(newQueen);
            move.setMovingPiece(newQueen);
        }
        else {
            capturedPiece = move.getDestSquare().removePiece();
        }
        if (capturedPiece != null) {
            capturedPiece.setCaptured();
        }
        move.setCapturedPiece(capturedPiece);

        move.getDestSquare().placePiece(move.getMovingPiece());
        move.getOrgSquare().removePiece();
        allMoves.add(move);
        move.getMovingPiece().addMove(move);
    }

    public void revertMove(Move move) {
        ChessPiece capturedPiece = move.getCapturedPiece();
        if (capturedPiece != null) {
            capturedPiece.setNotCaptured();
        }
        if (move.isPawnPromotion()) {
            ChessPiece queen = move.getMovingPiece();
            allOtherPieces.get(queen.getColor()).remove(queen);
            move.setMovingPiece(move.getCapturedPiece());
            move.setCapturedPiece(null);
        }
        move.getOrgSquare().placePiece(move.getMovingPiece());
        if (move.isEnPassant()) {
            Square square = getSquare(move.getDestSquare().getXPos(), move.getOrgSquare().getYPos());
            square.placePiece(capturedPiece);
        }
        else {
            move.getDestSquare().placePiece(capturedPiece);
        }
        if (move.isCastling()) {
            int xMovement = move.getDestSquare().getXPos() - move.getOrgSquare().getXPos();
            ChessPiece rook;
            int rookXDest;
            if (xMovement == 2) {
                rook = removePieceAtSquare(6, move.getDestSquare().getYPos());
                rookXDest = 8;
            }
            else {
                rook = removePieceAtSquare(4, move.getDestSquare().getYPos());
                rookXDest = 1;
            }
            move.getDestSquare().placePiece(move.getMovingPiece());
            move.getOrgSquare().removePiece();
            getSquare(rookXDest, move.getOrgSquare().getYPos()).placePiece(rook);
        }
        allMoves.remove(move);
        move.getMovingPiece().removeMove(move);
    }

    public boolean isPathUnblocked(Move move, boolean output) {
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
                if (output) {
                    System.out.println("You cannot capture your own piece");
                }
                return false; //destination square is occupied by piece with same color
            }
            if ((x != destXPos || y != destYPos) && squares[x][y].isOccupied()) {
                if (output) {
                    System.out.println("The path is blocked by one or more pieces");
                }
                return false; // other piece is blocking the path somewhere between origin and destination square
            }
        } while (x != destXPos || y != destYPos);
        return true;
    }

    public void setCheck(ChessColor color) {
        kings.get(color).setCheck();
    }

    public void setNotCheck(ChessColor color) {
        kings.get(color).setNotCheck();
    }

    public boolean isInCheck(ChessColor color) {
        return kings.get(color).isInCheck();
    }

    public ArrayList<ChessPiece> piecesCheckingKing(ChessColor kingColor) {
        ArrayList<ChessPiece> kingSlayers = new ArrayList<>();
        for (ChessPiece piece : allOtherPieces.get(kingColor.getOpposite())) {
            Move fromPieceToKing = new Move(piece.getSquare(), kings.get(kingColor).getSquare());
            if (!(piece.isCaptured()) && piece.isLegalMove(fromPieceToKing, false)) {
                kingSlayers.add(piece);
            }
        }
        return kingSlayers;
    }

    public boolean isCheckMate(ArrayList<ChessPiece> checkingPieces) {
     //   ChessPiece king = kings.get(checkingPieces.get(0).getColor().getOpposite());
        return false;
    }

    public void display() {
        System.out.print(String.format("%c[%d;%df", 0x1B, 5, 0)); // move cursor to row 5
        System.out.println("     -------------------------------");
        for (int y = 8; y > 0; y--) {
            System.out.print(" " + y + "  | ");
            for (int x = 1; x < 9; x++) {
                System.out.print(squares[x][y].getPieceSymbol() + " ");
                System.out.print("| ");
            }
            System.out.println();
            System.out.println("     -------------------------------");
        }
        System.out.println();
        System.out.print("      ");
        for (int letter = 65; letter < 73; letter++) {
            System.out.print((char)(letter) + "   ");
        }
        System.out.println();
    }
}