package baseball.game;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static boolean isValidInput(String input) {
        return isProperLength(input) && isAllDigits(input) && hasNoZero(input) && hasUniqueDigits(input);
    }

    private static boolean isProperLength(String input) {
        return input.length() == 3;
    }

    private static boolean isAllDigits(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean hasNoZero(String input) {
        return !input.contains("0");
    }

    private static boolean hasUniqueDigits(String input) {
        Set<Character> digits = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!digits.add(c)) {
                return false;
            }
        }
        return true;
    }
}
