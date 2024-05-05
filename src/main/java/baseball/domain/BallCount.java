package baseball.domain;

import static baseball.domain.constants.CountType.*;

import baseball.domain.constants.CountType;
import baseball.system.constants.Rule;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 스트라이크, 볼에 대한 정보를 가짐
 */
public class BallCount {

    Map<CountType, Integer> counts;

    public BallCount(int strike, int ball) {
        this.counts = new HashMap<>();
        counts.put(STRIKE, strike);
        counts.put(BALL, ball);
    }

    public boolean isNothing() {
        return getStrike() == 0 && getBall() == 0;
    }

    public int getStrike() {
        return counts.get(STRIKE);
    }

    public int getBall() {
        return counts.get(BALL);
    }
    public boolean isOut() {
        return getStrike() == Rule.BASEBALL_NUMBER_SIZE;
    }

    /**
     * 현재 볼카운트를 문자열로 반환합니다.
     * @return 볼카운트에 대한 문자열
     */
    public String getResultMessage() {
        StringBuilder ballCountBuilder = new StringBuilder();
        if (getBall() != 0) {
            ballCountBuilder.append(getBall()).append(BALL.getDescription()).append(" ");
        }
        if (getStrike() != 0) {
            ballCountBuilder.append(getStrike()).append(STRIKE.getDescription());
        }
        if (isNothing()) {
            ballCountBuilder.append(NOTHING.getDescription());
        }
        return ballCountBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallCount ballCount = (BallCount) o;
        return Objects.equals(counts, ballCount.counts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counts);
    }
}
