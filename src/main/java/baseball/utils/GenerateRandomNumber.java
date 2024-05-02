package baseball.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumber {

    static final int LENGTH = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    private List<Integer> generatedRandomNumber = new ArrayList<>();
    Random random = new Random();

    public List<Integer> generate() {
        generatedRandomNumber.clear();
        while (generatedRandomNumber.size() < LENGTH) {
            int randomNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            if (!generatedRandomNumber.contains(randomNumber)) {
                generatedRandomNumber.add(randomNumber);
            }
        }

        return generatedRandomNumber;
    }


}
