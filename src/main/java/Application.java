import utility.GameRestartOption;
import utility.InputStringReceiver;

public class Application {

    public static void main(String[] args) {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playBall();
        } while (GameRestartOption.isGameRestart());
        InputStringReceiver.close();
    }
}
