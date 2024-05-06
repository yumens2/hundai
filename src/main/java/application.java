import global.config.GamePackConfig;
import global.controller.GameController;

public class application {

    public static void main(String[] args) {
        GameController gameController = GamePackConfig.getGameController();
        gameController.playGame();
    }

}
