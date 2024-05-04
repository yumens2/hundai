package validate;
import Exception.*;
public class RestartValidator {

    public static void checkRestartNumber(int number) {
        if (number != 1 && number != 2) {
            throw new RestartNumberException();
        }
    }
}
