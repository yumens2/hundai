package baseball.controller;

import baseball.dto.ResultDto;
import baseball.model.Computer;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private final GameService gameService;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        computer = new Computer();
        gameService = new GameService(computer);
    }

    public void play() {
        do {
            computer.init();

            boolean playing;
            do {
                ResultDto resultDto = gameService.play(inputView.answer());
                outputView.result(resultDto);
                playing = !gameService.isCorrect(resultDto);
            } while (playing);

            outputView.gameOver();
        } while (gameService.restart(inputView.gameOver()));
    }
}
