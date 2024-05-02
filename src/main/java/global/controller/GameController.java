package global.controller;

import game.gamePack.GamePack;
import global.config.GamePackConfig;
import global.view.InputView;
import global.view.OutputView;
import java.util.List;

public class GameController {

    private static final int END = 0;
    List<GamePack> gamePackList = GamePackConfig.getGamePacks();

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
        int gameNumber = Integer.parseInt(InputView.printInputGameNumber());
        if (gameNumber == END) {
            return null;
        }
        return gamePackList.get(gameNumber - 1);
    }

}
