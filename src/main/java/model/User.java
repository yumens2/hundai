package model;

import util.NumberUtil;

public class User {
    private int[] numbers;

    public void setUserInput(String input) {
        numbers = NumberUtil.parseStringToNumbers(input);

        if(!NumberUtil.isDistinctNumbers(numbers)) {
            throw new IllegalArgumentException("Invalid input value");
        }
    }
    public int[] getNumbers() {
        return numbers;
    }
}
