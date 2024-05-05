package utils;

import error.ErrorMessage;

public class ValidationUtil {

    public static void isThreeDigits(int num) {
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException(ErrorMessage.THREE_DIGITS_ONLY);
        }
    }

}
