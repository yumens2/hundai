package model;

import util.NumberUtil;

public class Computer {
    private int[] numbers;

    public Computer() {
        numbers = NumberUtil.generateRandomNumber();
    }

    public int[] getNumber() {
        return numbers;
    }
}
