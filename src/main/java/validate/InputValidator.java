package validate;
import Exception.*;
import java.util.List;
import util.ListGenerator;

public class InputValidator {

    private InputValidator() {

    }

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

    public static void checkZeroNumber(int number) {
        List<Integer> integerList = ListGenerator.getIntegerList(number);
        if (integerList.contains(0)) {
            throw new ContainZeroException();
        }
    }
}
