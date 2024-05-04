package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;

public class GameController {

    private final InputView inputView;
    private final GameService gameService;

    public GameController() {
        inputView = new InputView();
        gameService = new GameService();
    }

    public void play() {
        gameService.play(inputView.answer());
    }
}
