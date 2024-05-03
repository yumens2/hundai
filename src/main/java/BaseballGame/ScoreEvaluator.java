package BaseballGame;

import java.util.List;

public class ScoreEvaluator {
    public String getScore(List<String> guess, String answer) {
        int strike = countStrikes(guess, answer);
        int ball = countBall(guess, answer);

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        else {
            return "%s볼 %s스트라이크".formatted(strike, ball);
        }
    }

    private int countStrikes(List<String> guess, String answer) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.indexOf(guess.get(i)) == i) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(List<String> guess, String answer) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.indexOf(guess.get(i)) != i && answer.contains(guess.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
