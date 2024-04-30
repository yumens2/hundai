package baseball.domain;

public class Hint {

    private static final int STRIKE_OUT_COUNT = 3;
    private static final int INITIAL_STRIKE_COUNT = 0;
    private static final int INITIAL_BALL_COUNT = 0;

    private int strike;
    private int ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public void increaseBall() {
        this.ball++;
    }

    public boolean isStrikeOut() {
        return strike == STRIKE_OUT_COUNT;
    }

    public boolean hasStrike() {
        return strike > INITIAL_STRIKE_COUNT;
    }

    public boolean hasBall() {
        return ball > INITIAL_BALL_COUNT;
    }

    public boolean isNothing() {
        return strike == INITIAL_STRIKE_COUNT && ball == INITIAL_BALL_COUNT;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
