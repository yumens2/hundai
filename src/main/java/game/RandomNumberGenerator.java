package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBERS_LENGTH = 3;

    private final Random random = new Random();

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < NUMBERS_LENGTH) {
            int number = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}