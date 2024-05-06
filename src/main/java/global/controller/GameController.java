package global.controller;

import game.gamePack.GamePack;
import global.config.GamePackConfig;
import global.validator.Validator;
import global.view.InputView;
import global.view.OutputView;
import java.util.List;

public class GameController {

    private static final int END = 0;
    private List<GamePack> gamePackList = GamePackConfig.getGamePacks();

    private GameController() {
    }

    private static class GameControllerHolder {

        private static final GameController gameController = new GameController();
    }

    public static GameController getInstance() {
        return GameControllerHolder.gameController;
    }


    public void playGame() {
        OutputView.printGameOpenMessage();
        GamePack gamePack = selectGamePack();
        while (gamePack != null) {
            gamePack.run();
            gamePack = selectGamePack();
        }
        OutputView.printEndGameMessage();
    }

    private GamePack selectGamePack() {
        OutputView.printGameList();
        String gameNumberInput = InputView.printInputGameNumber();
        Validator.validGamePackInput(gamePackList.size(), gameNumberInput);
        Integer gameNumber = Integer.parseInt(gameNumberInput);
        if (gameNumber == END) {
            return null;
        }
        return gamePackList.get(gameNumber - 1);
    }

}
