package baseball.utils;

import static baseball.model.Computer.LENGTH;

public class ValidateAnswer {

    public static boolean isCorrect(Integer strikeCount) {
        if (strikeCount == LENGTH) {
            return true;
        }
        else {
            return false;
        }
    }
}
