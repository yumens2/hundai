public class InputNumberValidator {

    public static void isPlayerNumberCorrect(String playerNumber) throws IllegalArgumentException {
        isStringLengthCorrect(playerNumber);
        isStringNumeric(playerNumber);
        isDifferentDigitNumber(playerNumber);
    }

    public static void isStringLengthCorrect(String string) {
        if (string.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void isStringNumeric(String string) throws IllegalArgumentException {
        for (int i = 0; i < string.length(); i++) {
            isCharacterNumeric(string, i);
        }
    }

    public static void isCharacterNumeric(String string, int index) {
        if (!Character.isDigit(string.charAt(index))) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDifferentDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (getDigitCount(number, number.charAt(i)) != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int getDigitCount(String number, char digit) {
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
