package baseball.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AnswerValidator {

    public static void validate(String input) throws IllegalArgumentException {
        validateInteger(input);
        validateDigit(input);
        validateRedundancy(input);
        validateNoZero(input);
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDigit(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRedundancy(String input) {
        Set<String> set = new HashSet<>(Arrays.asList(input.split("")));
        if (set.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNoZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }
}
