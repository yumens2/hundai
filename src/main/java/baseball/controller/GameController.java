package baseball.controller;

import baseball.model.BaseballNumber;
import baseball.model.Hint;
import baseball.model.RandomNumberGenerator;
import java.io.IOException;
import java.util.ArrayList;
import static baseball.view.InputView.readNumbers;
import static baseball.view.InputView.readWantGameRestart;
import static baseball.view.OutputView.*;

public class GameController {

    private static BaseballNumber opponent;

    public boolean run() throws IOException {
        boolean isGameFinished;

        do {
            requestNumberInput();
            ArrayList<Integer> playerNumber = readNumbers();

            BaseballNumber player = new BaseballNumber(playerNumber);
            Hint hint = player.compare(opponent);

            displayResult(hint);
            isGameFinished = hint.getIsGameFinished();
        } while (!isGameFinished);

        displayGameFinished();
        requestGameRestart();
        return readWantGameRestart();
    }

    public void init() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        opponent = new BaseballNumber(generator.generateRandomNumbers());
    }
}
