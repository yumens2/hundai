package game.gamePack.BaseballGame.config;

import game.gamePack.BaseballGame.model.BaseballGame;
import game.gamePack.BaseballGame.model.Computer;
import game.gamePack.BaseballGame.model.Result;
import game.gamePack.BaseballGame.service.BaseballGameService;
import game.gamePack.BaseballGame.view.OutputView;

public class BaseballGameConfig {

    private static final BaseballGame baseballGame = BaseballGame.of();
    private static final Computer computer = Computer.of();
    private static final Result result = Result.of();
    private static final BaseballGameService baseballGameService = BaseballGameService.of(computer,
        baseballGame, result);
    private static final OutputView outputView = OutputView.of();

    /**
     * 생성자 제한
     */
    private BaseballGameConfig() {
    }

    public static Computer getComputer() {
        return computer;
    }

    public static BaseballGameService getBaseballGameService() {
        return baseballGameService;
    }

}
