package baseball.utils;

public class ValidateRestart {

    public static boolean restartGame(String signal) {
        if (signal.equals("1")) {
            return true;
        }
        else {
            return false;
        }
    }
}
