import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AutomaticBallStrikeSystem {

    public Result determine(int number, int answer) {
        int strikeCount = determineStrike(number, answer);
        int ballCount = determineBall(number, answer);
        return new Result(strikeCount, ballCount);
    }

    private int determineStrike(int number, int answer) {
        int strike = 0;
        while (number > 0) {
            Integer unitsOfNumber = number % 10;
            Integer unitsOfAnswer = answer % 10;
            if (unitsOfNumber == unitsOfAnswer) {
                strike += 1;
            }
            number /= 10;
            answer /= 10;
        }
        return strike;
    }

    private int determineBall(Integer number, Integer answer) {
        int ball = 0;
        String numToStr = number.toString();
        String ansToStr = answer.toString();

        for (int i = 0; i < numToStr.length(); i++) {
            char numChar = numToStr.charAt(i);
            for (int j = 0; j < ansToStr.length(); j++) {
                char ansChar = ansToStr.charAt(j);
                if (i != j && numChar == ansChar) {
                    ball += 1;
                }
            }
        }
        return ball;
    }
}

