package main;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private final Random random = new Random();

    public String generateNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            int randomNum = 1 + random.nextInt(9);
            numbers.add(randomNum);
        }
        return numbers.stream().map(String::valueOf).reduce("", String::concat);
    }

    public boolean isValidNumber(String input) {
        if (input.length() != 3) return false;
        return input.chars().distinct().count() == 3 && input.matches("[1-9]+");
    }
}

