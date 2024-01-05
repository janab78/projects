import java.util.Scanner;
import java.util.ArrayList;

public class ChessGame {
    ChessColor curTurn;
    ChessBoard board;
    boolean ongoing;
    ArrayList<Move> allMoves;
    Scanner inputScanner;

    public ChessGame() {
        curTurn = ChessColor.WHITE;
        board = new ChessBoard();
        ongoing = true;
        allMoves = new ArrayList<Move>();
        inputScanner = new Scanner(System.in);
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void displayBoard() {
        board.display();
    }

    public void displayNextMove() {
        System.out.println();
        System.out.println();
        System.out.println("Next move: " + curTurn);
    }

    private Move getMoveFromPlayer(Scanner sc) {
        String playerInput;
        do {
            System.out.print("Enter move (e.g. \"a2 a4\" or \"q\" to quit): ");
            playerInput = sc.nextLine();
        } while (!playerInput.matches("[a-h][1-8]\s[a-h][1-8]") && !playerInput.equals("q"));
        if (playerInput.equals("q")) {
            return null;
        }
        String[] inputParts = playerInput.trim().split("\\s+");
        return new Move(new SquarePos(inputParts[0]), new SquarePos(inputParts[1]));
    } 

    public void nextMove() {
        Move selectedMove = getMoveFromPlayer(inputScanner);
        if (selectedMove == null) {
            ongoing = false;
            inputScanner.close();
        }
        else {
            ChessPiece movingPiece = board.getMovingPiece(selectedMove);
            if (movingPiece.isLegalMove(selectedMove)) {
                board.implementMove(selectedMove);
                allMoves.add(selectedMove);
                curTurn = curTurn.getOpposite();
            }
            else {
                System.out.println("Illegal move");
            }
        }
    }
}