package game.gamePack.BaseballGame.config;

import game.gamePack.BaseballGame.model.Computer;
import game.gamePack.BaseballGame.service.BaseballGameService;

public class BaseballGameConfig {

    private static final BaseballGameService baseballGameService = BaseballGameService.of();
    private static final Computer computer = Computer.of();

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
