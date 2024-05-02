package baseball.controller;

import baseball.domain.Player;
import baseball.domain.Computer;
import baseball.service.GameService;
import baseball.service.ScoreService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.io.IOException;

public class GameController {

    Computer computer = new Computer();
    Player player = new Player();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ScoreService scoreService = new ScoreService();
    GameService gameService = new GameService();
    private final int STRIKE_INDEX = 0;

    public void run() throws IOException {
        outputView.startGame();
        computer.setComputerNumber();
        while (!gameService.isEndGame()) {
            inputController();
            scoreController();
        }


    }

    public void inputController() throws IOException {
        inputView.setPlayerNumber();
        player.setPlayerNumbers(inputView.getPlayerNumbers());

    }

    public void retryInputController() throws IOException {
        inputView.setRetryInput();
        gameService.setEndGame(inputView.getRetryNumbers(), computer);
    }

    public void scoreController() throws IOException {
        int[] score = scoreService.getScore(computer.getComputerNumbers(),
            player.getPlayerNumbers());
        if (score[STRIKE_INDEX] == 3) {
            outputView.clearGame();
            retryInputController();
        }
        if (score[STRIKE_INDEX] != 3) {
            outputView.notClearGame(score);
        }
    }

}
