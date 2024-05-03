package utility;

import java.util.Arrays;
import java.util.List;

public class RestartNumberValidator {

    private static final List<String> restartNumberList = Arrays.asList("1", "2");

    public static void isRestartNumberCorrect(String inputNumber) {
        for (String restartNumber : restartNumberList) {
            if (inputNumber.equals(restartNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
