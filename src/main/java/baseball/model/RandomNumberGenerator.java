package baseball.model;


import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
    private static final int DIGIT = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final Random random = new Random();

    public ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < DIGIT) {
            int randomNumber = generateRandomNumber();
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static int generateRandomNumber() {
        return random.nextInt(END_NUMBER - START_NUMBER + 1) + START_NUMBER; // 1부터 9까지
    }
}