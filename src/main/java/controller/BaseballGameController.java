package controller;

import model.GenerateRandomNumber;
import view.InputView;

import java.util.List;

public class BaseballGameController {

    private final static GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    private final static InputView input = new InputView();

    public void progress() {
        // generate random number
        List<Integer> answerNum = generateRandomNumber.getRandomNumberList();
        // input & validation
        List<Integer> inputNum = input.input();
    }

}
