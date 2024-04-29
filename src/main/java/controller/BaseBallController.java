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
        BaseBallService baseBallService = new BaseBallService(randomNumberGenerator.createRandomNumber());
        inputOneAnswer(baseBallService);
    }

    private void inputOneAnswer(BaseBallService baseBallService) {
        String playerAnswer = inputView.getPlayerAnswer();
        final Player player = Player.create(playerAnswer);
        Score score = baseBallService.startOneGame(player);
        ScoreDto scoreDto = new ScoreDto(score);
        outputView.showGameScore(scoreDto.getStrike(), scoreDto.getBall());
        if (baseBallService.checkGameEnd(player)) {

        }
    }
}
