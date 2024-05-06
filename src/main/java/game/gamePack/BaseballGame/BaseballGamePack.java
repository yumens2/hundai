package game.gamePack.BaseballGame;

import game.gamePack.BaseballGame.config.BaseballGameConfig;
import game.gamePack.BaseballGame.service.BaseballGameService;
import game.gamePack.GamePack;

public class BaseballGamePack implements GamePack {

    private final BaseballGameService baseballGameService = BaseballGameConfig.getBaseballGameService();

    private static final String GAME_NAME = "야구 게임";

    public void run() {
        do {
            baseballGameService.playGame();
        } while (baseballGameService.exitGame());
    }

    public String getGameName() {
        return GAME_NAME;
    }


}
