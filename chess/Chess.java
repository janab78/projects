public class Chess {

    public static void main(String[] args) {
        ChessGame game = new ChessGame();

        while (game.isOngoing()) {
            game.displayBoard();
            game.displayNextMove();
            game.nextMove();
        }
    }
}