package utility;

public class InputNumberValidator {

    protected static void isStringLengthCorrect(String string, int stringLength) {
        if (string.length() != stringLength) {
            throw new IllegalArgumentException();
        }
    }

    protected static void isStringNumeric(String string) throws IllegalArgumentException {
        for (int i = 0; i < string.length(); i++) {
            isCharacterNumeric(string.charAt(i));
        }
    }

    private static void isCharacterNumeric(char singleCharacter) {
        if (!Character.isDigit(singleCharacter) || singleCharacter == '0') {
            throw new IllegalArgumentException();
        }
    }

    protected static void isDifferentDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (getDigitCount(number, number.charAt(i)) != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static int getDigitCount(String number, char digit) {
        return Math.toIntExact(number.chars()
                .filter((ch) -> (ch == digit))
                .count());
    }
}
