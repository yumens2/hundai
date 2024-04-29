package baseball.model;

public class Hint {

    private static final int GAME_FINISH_NUM = 3;
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() { return strike; }

    public int getBall() { return ball; }

    public boolean getIsGameFinished() {
        return strike == GAME_FINISH_NUM;
    }
}
