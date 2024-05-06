package game.gamePack.BaseballGame.config;

import game.gamePack.BaseballGame.model.BaseballGame;
import game.gamePack.BaseballGame.model.Computer;
import game.gamePack.BaseballGame.model.Result;
import game.gamePack.BaseballGame.service.BaseballGameService;

public class BaseballGameConfig {

    private static final BaseballGame baseballGame = BaseballGame.getInstance();
    private static final Computer computer = Computer.getInstance();
    private static final Result result = Result.getInstance();
    private static final BaseballGameService baseballGameService = BaseballGameService.getInstance(
        computer,
        baseballGame, result);

    /**
     * 생성자 제한
     */
    private BaseballGameConfig() {
    }

    public static BaseballGameService getBaseballGameService() {
        return baseballGameService;
    }

}
