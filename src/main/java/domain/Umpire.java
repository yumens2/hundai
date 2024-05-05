package domain;

import utility.BaseballCountCalculator;

public class Umpire {

    private final BaseballCount baseballCount;
    private static final int MAX_STRIKE_COUNT = 3;

    public Umpire() {
        this.baseballCount = new BaseballCount();
    }

    public void setBaseballCountWithCalculator(Player player, Computer computer) {
        int ballCount = BaseballCountCalculator.countBall(player.getPlayerNumber(), computer.getAnswerNumber());
        int strikeCount = BaseballCountCalculator.countStrike(player.getPlayerNumber(), computer.getAnswerNumber());
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
