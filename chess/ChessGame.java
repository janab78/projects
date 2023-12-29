public class ChessGame {
    ChessColor curTurn;
    ChessBoard board;

    public ChessGame() {
        curTurn = ChessColor.WHITE;
        board = new ChessBoard();
        board.display();
    }
}