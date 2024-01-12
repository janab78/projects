public class Chess {

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.clearScreen();

        while (game.isOngoing()) {
            game.displayBoard();
            game.displayNextMove();
            game.nextMove();
        }
    }
}