package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int number;
    private BallType ballType;

    public Ball(BallType ballType,int number) {
        this.ballType = ballType;
        this.number = number;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball ball)) return false;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
