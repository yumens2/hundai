package BaseballGame;

import java.util.List;

public class ScoreEvaluator {
    public List<Integer> getScore(List<String> guess, String answer) {
        int strike = countStrikes(guess, answer);
        int ball = countBall(guess, answer);

        return List.of(strike, ball);
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
