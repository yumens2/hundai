import game.StartGame;
import io.ContinueOrNot;

public class Application {

    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            StartGame.startGame();
            isContinue = ContinueOrNot.isContinueGame();
        }
    }
}
