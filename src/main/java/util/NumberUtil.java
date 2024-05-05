package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberUtil {
    public static int[] generateRandomNumber() {
        Set<Integer> generatedNumbers = new HashSet<>();
        Random random = new Random();

        while(generatedNumbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            generatedNumbers.add(randomNumber);
        }

        int[] numbers = new int[3];
        int index = 0;
        for(int num : generatedNumbers) {
            numbers[index++] = num;
        }

        return numbers;
    }

    public static int[] splitNumber(String numberString) {
        //TODO
    }
}
