package domain;

import static domain.BaseballGame.MAX_NUMBER;
import static domain.BaseballGame.MIN_NUMBER;

import common.module.RandomNumberGenerator;
import java.util.ArrayList;

public class ComputerPlayer implements Player {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private ArrayList<Integer> numbers = new ArrayList<>();

    @Override
    public void generateNumbers() {

        for (int i = 0; i < BaseballGame.NUMBER_SIZE; i++) {
            int number = randomNumberGenerator.generateRandomNumberInRange(MIN_NUMBER, MAX_NUMBER);
            while (numbers.contains(number)) {
                number = randomNumberGenerator.generateRandomNumberInRange(MIN_NUMBER, MAX_NUMBER);
            }
            numbers.add(number);
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
