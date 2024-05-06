package uilts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class makeRandomNumber {
    public static int[] getRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = numberList.get(i);
        }

        return result;
    }
}
