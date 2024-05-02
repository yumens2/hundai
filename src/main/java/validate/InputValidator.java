package validate;
import Exception.*;
public class InputValidator {

    public static void checkDuplicate(int number) {
        String num = String.valueOf(number);
        if (num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2)
            || num.charAt(0) == num.charAt(2)) {
            throw new DuplicateException();
        }
    }

    public static void checkInvalidLength(int number) {
        String num = String.valueOf(number);
        if (num.length() != 3) {
            throw new InvalidLengthException();
        }
    }
}
