package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNonZeroNumberGenerator implements NumberGenerator {

    private static final int DIGIT = 3;
    private static final Random random = new Random();

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != DIGIT) {
            int randomNumber = random.nextInt(9) + 1;
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
