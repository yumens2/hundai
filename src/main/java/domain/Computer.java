package domain;

import utility.RandomNumberGenerator;

public class Computer {

    private String answerNumber;

    public Computer() {
        setAnswerNumberByRandomNumber();
    }

    private void setAnswerNumberByRandomNumber() {
        this.answerNumber = RandomNumberGenerator.getRandomNumber();
    }

    public String getAnswerNumber() {
        return answerNumber;
    }
}
