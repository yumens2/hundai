import baseball.BaseballGame;
import baseball.service.DefaultGameService;

public class Application {
    public static void main(String[] args) {
        new GameController(new BaseballGame(new DefaultGameService())).runGame();
    }
}