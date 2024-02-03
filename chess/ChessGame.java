import java.util.Scanner;
import java.util.ArrayList;

public class ChessGame {
    ChessColor curTurn;
    ChessBoard board;
    boolean ongoing;
    Scanner inputScanner;

    public ChessGame() {
        curTurn = ChessColor.WHITE;
        board = new ChessBoard();
        ongoing = true;
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
            System.out.print("Enter move (e.g. \"a2a4\" or \"q\" to quit): ");
            playerInput = sc.nextLine();
        } while (!playerInput.matches("[a-h][1-8][a-h][1-8]") && !playerInput.equals("q"));
        if (playerInput.equals("q")) {
            return null;
        }
        playerInput.trim();
        int origXPos = (int)(playerInput.charAt(0)) - 96;
        int origYPos = (int)(playerInput.charAt(1)) - 48;
        int destXPos = (int)(playerInput.charAt(2)) - 96;
        int destYPos = (int)(playerInput.charAt(3)) - 48;
        return new Move(board.getSquare(origXPos, origYPos), board.getSquare(destXPos, destYPos));
    } 

    public void nextMove() {
        Move selectedMove = getMoveFromPlayer(inputScanner);
        if (selectedMove == null) {
            ongoing = false;
            inputScanner.close();
        }
        else {
            clearScreen();
            ChessPiece movingPiece = selectedMove.getMovingPiece();
            if (movingPiece != null && movingPiece.getColor() == curTurn) {
                if (movingPiece.isLegalMove(selectedMove, true)) {
                    board.implementMove(selectedMove);
                    if (board.piecesCheckingKing(curTurn).size() == 0) {
                        ArrayList<ChessPiece> piecesCheckingOppositeKing = board.piecesCheckingKing(curTurn.getOpposite());
                        if (piecesCheckingOppositeKing.size() > 0) {
                            if (board.isCheckMate(piecesCheckingOppositeKing)) {
                                ongoing = false;
                                System.out.println("Game over - " + curTurn + " win");
                            }
                            else {
                                board.setCheck(curTurn.getOpposite());
                                System.out.println(curTurn.getOpposite() + " is in check");
                            }
                        }
                        else {
                            board.setNotCheck(curTurn.getOpposite());
                        }
                        curTurn = curTurn.getOpposite();
                    }
                    else {
                        if (board.isInCheck(curTurn)) {
                            System.out.println(curTurn + " king will still be in check after this move");
                        }
                        else {
                            System.out.println(curTurn + " (your own) king will be in check after this move");
                        }
                        System.out.println("Illegal move: " + selectedMove);
                        board.revertMove(selectedMove);
                    }
                }
                else {
                    System.out.println("Illegal move: " + selectedMove);
                }
            }
            else {
                if (movingPiece == null) {
                    System.out.println("No piece to move");
                }
                else {
                    System.out.println(curTurn + " cannot move a " + movingPiece.getColor() + " piece");
                }
            }
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}