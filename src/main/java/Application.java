public class Application {

    private static final Game game = new Game();

    public static void main(String[] args) {
        do {
            game.runGame();
        } while (game.checkReplay());

        game.end();
    }

}
