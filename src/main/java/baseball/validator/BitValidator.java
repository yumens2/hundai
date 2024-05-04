package baseball.validator;

public class BitValidator {

    public static void validate(String input) throws IllegalArgumentException {
        validateInteger(input);
        validateNumber(input);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumber(String input) {
        int number = Integer.parseInt(input);

        if (number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }
}
