package utility;

public class InputNumberValidator {

    public static void isPlayerNumberCorrect(String playerNumber) throws IllegalArgumentException {
        isStringLengthCorrect(playerNumber);
        isStringNumeric(playerNumber);
        isDifferentDigitNumber(playerNumber);
    }

    private static void isStringLengthCorrect(String string) {
        if (string.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void isStringNumeric(String string) throws IllegalArgumentException {
        for (int i = 0; i < string.length(); i++) {
            isCharacterNumeric(string.charAt(i));
        }
    }

    private static void isCharacterNumeric(char singleChar) {
        if (!Character.isDigit(singleChar) || singleChar == '0') {
            throw new IllegalArgumentException();
        }
    }

    private static void isDifferentDigitNumber(String number) {
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

    public static void isRestartNumberCorrect(String selectionNumber) {
        if (!selectionNumber.equals("1") && !selectionNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
