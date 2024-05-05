package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    public static int[] generateRandomNumbers() {
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numbersList.add(i);
        }

        Collections.shuffle(numbersList);

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = numbersList.get(i);
        }

        return numbers;
    }
}
