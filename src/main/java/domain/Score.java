package domain;

import domain.wrapper.Ball;
import domain.wrapper.Strike;

public class Score {

    private Strike strke;
    private Ball ball;

    private Score(Strike strke, Ball ball) {
        this.strke = strke;
        this.ball = ball;
    }

    public static Score create(Strike strike, Ball ball) {
        return new Score(strike, ball);
    }

    public Strike getStrke() {
        return strke;
    }

    public Ball getBall() {
        return ball;
    }
}
