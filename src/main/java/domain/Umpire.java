package domain;

import utility.BaseballCountCalculator;

public class Umpire {

    private final BaseballCount baseballCount;
    private static final int MAX_STRIKE_COUNT = 3;

    public Umpire() {
        this.baseballCount = new BaseballCount();
    }

    public void setBaseballCountWithCalculator(String playerNumber, String answerNumber) {
        int ballCount = BaseballCountCalculator.countBall(playerNumber, answerNumber);
        int strikeCount = BaseballCountCalculator.countStrike(playerNumber, answerNumber);
        ballCount = BaseballCountCalculator.countBallExceptForStrike(ballCount, strikeCount);
        baseballCount.setBaseballCount(ballCount, strikeCount);
    }

    public BaseballCount getBaseballCount() {
        return baseballCount;
    }

    public boolean isPlayerWon() {
        return baseballCount.getStrikeCount() == MAX_STRIKE_COUNT;
    }
}
