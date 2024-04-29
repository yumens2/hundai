public class InputNumberValidator {

    public static boolean isInputNumberCorrect(String inputNumber) {
        return isStringLengthCorrect(inputNumber) && isStringNumeric(inputNumber) && isDifferentDigitNumber(inputNumber);
    }

    public static boolean isStringLengthCorrect(String string) throws IllegalStateException {
        if (string.length() != 3) {
            throw new IllegalStateException();
        }
        return true;
    }

    public static boolean isStringNumeric(String string) {
        for (int i = 0; i < string.length(); i++) {
            isCharacterNumeric(string, i);
        }
        return true;
    }

    public static void isCharacterNumeric(String string, int index) throws IllegalStateException {
        if (!Character.isDigit(string.charAt(index))) {
            throw new IllegalStateException();
        }
    }

    public static boolean isDifferentDigitNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (getDigitCount(number, number.charAt(i)) != 1) {
                throw new IllegalStateException();
            }
        }
        return true;
    }

    public static int getDigitCount(String number, char digit) {
        return Math.toIntExact(number.chars()
                .filter((ch) -> (ch == digit))
                .count());
    }
}
