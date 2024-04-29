package controller;

import domain.Player;
import domain.Score;
import domain.dto.ScoreDto;
import domain.service.BaseBallService;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallController {

    private final InputView inputView;
    private final OutputView outputView;
    private BaseBallService baseBallService;

    public BaseBallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.create();
        this.baseBallService = new BaseBallService(randomNumberGenerator.createRandomNumber());
        inputOneAnswer();
    }

    private void inputOneAnswer() {
        String playerAnswer = inputView.getPlayerAnswer();
        final Player player = Player.create(playerAnswer);
        Score score = baseBallService.startOneGame(player);
        ScoreDto scoreDto = new ScoreDto(score);
        outputView.showGameScore(scoreDto.getStrike(), scoreDto.getBall());
        if (baseBallService.checkGameEnd(player)) {
            askRestartOrExit();
            return;
        }
        inputOneAnswer();
    }

    private void askRestartOrExit() {
        outputView.showGameEnd();
        int condition = inputView.getRestartCondition();
        if (condition == 1) {
            start();
            return;
        }
        if (condition == 2) {
            return;
        }
        askRestartOrExit();
    }
}
