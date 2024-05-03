package baseball.utils;

public class ValidateRestart {

    public static boolean restartGame(Integer signal) {
        if (signal == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
