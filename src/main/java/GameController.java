import baseball.BaseballGame;
import baseball.View;

public class GameController {
    private BaseballGame baseballGame;

    public GameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void runGame() {
        baseballGame.init();
        baseballGame.startGame();
        if (View.askRestart().isRestart()) {
            runGame();
        }
    }
}
