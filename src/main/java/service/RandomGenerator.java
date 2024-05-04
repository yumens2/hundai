package service;

import model.Number;

import java.util.Random;

public class RandomGenerator {

    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    public Number createNumber() {
        int[] number = new int[3];
        int index = 1;
        number[0] = random.nextInt(9) + 1;

        while (index < 3) {
            int num = random.nextInt(9) + 1;

            for (int j = 0; j < index; j++) {
                if (number[j] == num) {
                    break;
                }
                if (j + 1 == index) {
                    number[index++] = num;
                }
            }
        }

        return new Number(number);
    }
}
