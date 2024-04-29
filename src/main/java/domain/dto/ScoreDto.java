package domain.dto;

import domain.Score;
import domain.wrapper.Ball;
import domain.wrapper.Strike;

public class ScoreDto {

    private Strike strike;
    private Ball ball;

    public ScoreDto(Score score) {
        this.strike = score.getStrke();
        this.ball = score.getBall();
    }

    public Strike getStrike() {
        return strike;
    }

    public Ball getBall() {
        return ball;
    }
}
