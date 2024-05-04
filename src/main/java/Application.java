import java.io.IOException;

public class Application {
	private static final int QUIT = 2;
	private static final int RESTART = 1;

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		do{
			game.initGame();
			game.runGame();
		} while(game.stateController() == 1);
	}
}
