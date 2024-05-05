package controller;

import model.AnswerChecker;
import model.GenerateRandomNumber;
import model.Hint;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballGameControllerTest {

    private final static GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    private final static InputView input = new InputView();
    private final static AnswerChecker answerChecker = new AnswerChecker();
    private final static OutputView outputView = new OutputView();

    private BaseballGameController baseballGameController;

    @Test
    void progress() {
        // Generate a random number
        List<Integer> answerNum = List.of(1, 2, 3);

        // Simulate user input for replay
        boolean isReplay = false;

        // Simulate answer checking result
        Hint hint = answerChecker.checkAnswer(answerNum, List.of(1, 2, 3));

        // Verify that the game ends after one iteration
        assertThat(answerChecker.isFinished(hint)).isTrue();
    }

    @Test
    void testOneGame() {
        // Generate a random number
        List<Integer> answerNum = List.of(5, 8, 4);

        // Simulate user input
        List<Integer> userInput = List.of(5, 8, 4);

        // Simulate answer checking result
        Hint hint = answerChecker.checkAnswer(answerNum, userInput);

        // Verify that the correct hint is returned
        assertThat(hint.getStrike()).isEqualTo(3);
        assertThat(hint.getBall()).isZero();
    }
}