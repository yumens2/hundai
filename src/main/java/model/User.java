package model;

import util.NumberUtil;

public class User {
    private String input;
    public User(String input) {
        this.input = input;
    }
    public int[] getNumbers() {
        int[] numbers = NumberUtil.parseStringToNumbers(input);

        if(!NumberUtil.isDistinctNumbers(numbers)) {
            throw new IllegalArgumentException("Invalid input value");
        }

        return numbers;
    }
}
