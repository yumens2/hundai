package global.controller;

import game.gamePack.GamePack;
import global.config.GamePackConfig;
import global.view.InputViewHandler;
import global.view.MainViewHandler;
import java.util.List;

public class GameController {

    List<GamePack> gamePackList = GamePackConfig.getGamePacks();

    public void playGame() {
        MainViewHandler.printGameOpenMessage();
        do {
            GamePack gamePack = selectGamePack();
            gamePack.run();
        } while (true);
    }

    private GamePack selectGamePack() {
        MainViewHandler.printGameList();
        int gameNumber = Integer.parseInt(InputViewHandler.printInputGameNumber());
        return gamePackList.get(gameNumber - 1);
    }

}
