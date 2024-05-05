package controller;

import model.AnswerChecker;
import model.GenerateRandomNumber;
import model.Hint;
import view.InputView;

import java.util.List;

public class BaseballGameController {

    private final static GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    private final static InputView input = new InputView();
    private final AnswerChecker answerChecker = new AnswerChecker();


    public void progress() {
        // generate random number
        List<Integer> answerNum = generateRandomNumber.getRandomNumberList();
        // input & validation
        List<Integer> inputNum = input.input();
        // check Answer
        Hint hint = answerChecker.checkAnswer(answerNum, inputNum);
    }

}
