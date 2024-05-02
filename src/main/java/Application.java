import baseball.controller.GameController;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController();
        gameController.run();
    }
}
