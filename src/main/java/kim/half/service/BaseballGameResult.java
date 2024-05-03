package kim.half.service;

import kim.half.domain.Baseballs;
import kim.half.ui.OutputBuilder;


public class BaseballGameResult {

    private static final int COUNT_ZERO = 0;
    private final int strikeNumber;
    private final int ballNumber;

    public BaseballGameResult(Baseballs computerBaseballs, Baseballs userBaseballs) {
        strikeNumber = computerBaseballs.countStrike(userBaseballs);
        ballNumber = computerBaseballs.countBall(userBaseballs);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();

        if (strikeNumber == COUNT_ZERO && ballNumber == COUNT_ZERO) {
            sb.append(OutputBuilder.RESULT_NOTHING_MESSAGE);
        }
        if (strikeNumber != COUNT_ZERO) {
            sb.append(strikeNumber).append(OutputBuilder.RESULT_STRIKE_MESSAGE);
        }
        if (ballNumber != COUNT_ZERO) {
            sb.append(ballNumber).append(OutputBuilder.RESULT_BALL_MESSAGE);
        }
        return sb.toString();
    }
}
