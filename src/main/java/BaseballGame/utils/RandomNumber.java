package utils;

import java.util.ArrayList;

public class RandomNumber {
    public static ArrayList<Integer> generateRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int number = (int) (Math.random() * 9) + 1;
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }

        return randomNumbers;
    }
}
