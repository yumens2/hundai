public class InputNumberValidator {

    public static void isInputNumberCorrect(String inputNumber) throws IllegalStateException {
        isStringLengthCorrect(inputNumber);
        isStringNumeric(inputNumber);
        isDifferentDigitNumber(inputNumber);
    }

    public static void isStringLengthCorrect(String string) throws IllegalStateException {
        if (string.length() != 3) {
            throw new IllegalStateException();
        }
    }

    public static void isStringNumeric(String string) throws IllegalStateException {
        for (int i = 0; i < string.length(); i++) {
            isCharacterNumeric(string, i);
        }
    }

    public static void isCharacterNumeric(String string, int index) {
        if (!Character.isDigit(string.charAt(index))) {
            throw new IllegalStateException();
        }
    }

    public static void isDifferentDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (getDigitCount(number, number.charAt(i)) != 1) {
                throw new IllegalStateException();
            }
        }
    }

    public static int getDigitCount(String number, char digit) {
        return Math.toIntExact(number.chars()
                .filter((ch) -> (ch == digit))
                .count());
    }
}
