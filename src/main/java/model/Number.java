package model;

import java.util.Arrays;

public class Number {

    private final int[] numbers;

    public Number(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int toInt() {
        return numbers[0]*100 + numbers[1]*10 + numbers[2];
    }
}
