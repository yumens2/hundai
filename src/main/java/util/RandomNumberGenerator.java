package util;

import java.util.LinkedHashSet;
import java.util.Random;

public class RandomNumberGenerator {

    private final static int START_DIGIT = 1;
    private final static int END_DIGIT = 9;
    private Random random;
    private String randomNumber;

    private RandomNumberGenerator() {
        random = new Random();
        randomNumber = "";
    }

    public static RandomNumberGenerator create() {
        return new RandomNumberGenerator();
    }

    public String createRandomNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<String>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }
        this.randomNumber = String.join("", computerNumberCheck);
        return randomNumber;
    }

    private String getRandomNumber() {
        return Integer.toString(random.nextInt(END_DIGIT) + START_DIGIT);
    }
}
