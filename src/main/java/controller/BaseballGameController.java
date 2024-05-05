package controller;

import model.AnswerChecker;
import model.GenerateRandomNumber;
import model.Hint;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BaseballGameController {

    private final static GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    private final static InputView input = new InputView();
    private final AnswerChecker answerChecker = new AnswerChecker();
    private final OutputView outputView = new OutputView();

    public void progress() {
        boolean isFinish = false;
        do {
            List<Integer> answerNum = generateRandomNumber.getRandomNumberList();

            oneGame(answerNum);

            isFinish = input.isReplay();

        } while (isFinish);
    }

    private void oneGame(List<Integer> answerNum) {
        while (true) {
            // feat: input & validation
            List<Integer> inputNum = input.input();
            // feat: checkAnswer
            Hint hint = answerChecker.checkAnswer(answerNum, inputNum);
            // feat: print Console
            outputView.printResult(hint);
            if (answerChecker.isFinished(hint)) {
                break;
            }
        }
    }

}
