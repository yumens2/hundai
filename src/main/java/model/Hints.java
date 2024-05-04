package model;

public class Hints {

    private final int strike;
    private final int ball;

    public Hints(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasStrikesAndBalls() {
        return strike > 0 && ball > 0;
    }

    public boolean hasStrikes() {
        return strike > 0 && ball == 0;
    }

    public boolean hasBalls() {
        return ball > 0 && strike == 0;
    }

    public boolean hasNothing() {
        return strike == 0 && ball == 0;
    }


}
