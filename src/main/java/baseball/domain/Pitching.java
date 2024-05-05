package baseball.domain;

import baseball.Validator;
import baseball.domain.Ball;
import baseball.domain.BallType;

import java.util.List;

public class Pitching {
    private List<Ball> balls;

    public Pitching(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int ballCount = 0;
        int strikeCount = 0;
        for (Ball ball : balls) {
            if (ball.getBallType() == BallType.BALL) {
                ballCount++;
            }
            if (ball.getBallType() == BallType.STRIKE) {
                strikeCount++;
            }
        }
        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
    public boolean isThreeStrike() {
        // balltype이 strike 인지 확인
        return balls.stream()
                .filter(ball -> ball.getBallType() == BallType.STRIKE)
                .count() == 3;
    }
}