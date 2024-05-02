package game.gamePack.BaseballGame.service;

import game.gamePack.BaseballGame.model.BaseballGame;
import game.gamePack.BaseballGame.model.Computer;
import game.gamePack.BaseballGame.model.Result;
import game.gamePack.BaseballGame.view.OutputView;
import java.util.List;

public class BaseballGameService {

    private static BaseballGameService baseballGameService;
    private final BaseballGame baseballGame;
    private final Result result;
    private final Computer computer;

    public static BaseballGameService of(Computer computer, BaseballGame baseballGame,
        Result result) {
        if (baseballGameService == null) {
            baseballGameService = new BaseballGameService(computer, baseballGame, result);
        }
        return baseballGameService;
    }

    private BaseballGameService(Computer computer, BaseballGame baseballGame, Result result) {
        this.computer = computer;
        this.baseballGame = baseballGame;
        this.result = result;
    }

    public void playGame() {
        OutputView.printGameStartMessage();
        List<Integer> computerNumbers = computer.getTargetNumbers();
        List<Integer> guessNumber;
        do {
            guessNumber = baseballGame.GuessNumbers();
        } while (result.getOutCome(computerNumbers, guessNumber));
    }

    public boolean exitGame() {
        return false;
    }


}
