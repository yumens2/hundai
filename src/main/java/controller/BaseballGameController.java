package controller;

import model.GenerateRandomNumber;

import java.util.List;

public class BaseballGameController {

    private final static GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();

    public void progress() {
        // generate random number
        List<Integer> answerNum = generateRandomNumber.getRandomNumberList();
    }

}
