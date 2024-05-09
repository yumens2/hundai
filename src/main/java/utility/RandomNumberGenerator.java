package utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final int MAX_DIGIT_NUMBER = 9;
    private static final int DIGIT_RANGE_OFFSET = 1;

    private RandomNumberGenerator() {}

    public static String getRandomNumber() {
        List<String> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < RANDOM_NUMBER_LENGTH) {
            appendRandomSingleDigit(randomNumberList);
        }
        return String.join("", randomNumberList);
    }

    private static void appendRandomSingleDigit(List<String> numberList) {
        Random randomGenerator = new Random();
        String randomSingleDigit = Integer.toString(randomGenerator.nextInt(MAX_DIGIT_NUMBER) + DIGIT_RANGE_OFFSET);
        if (!numberList.contains(randomSingleDigit)){
            numberList.add(randomSingleDigit);
        }
    }
}
