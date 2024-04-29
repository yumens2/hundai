package baseball.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class BaseballNumberTest {

    @Test
    void 모든_숫자가_스트라이크일_경우() {
        // given
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber opponentNumber = new BaseballNumber(Arrays.asList(1, 2, 3));

        // when
        Hint result = playerNumber.compare(opponentNumber);

        // then
        assertEquals(3, result.getStrike(), "모든 숫자가 스트라이크여야 함");
        assertEquals(0, result.getBall(), "볼이 없어야 함");
    }

    @Test
    void 모든_숫자가_볼일_경우() {
        // given
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber opponentNumber = new BaseballNumber(Arrays.asList(3, 1, 2));

        // when
        Hint result = playerNumber.compare(opponentNumber);

        // then
        assertEquals(0, result.getStrike(), "스트라이크가 없어야 함");
        assertEquals(3, result.getBall(), "모든 숫자가 볼이어야 함");
    }

    @Test
    void 스트라이크와_볼이_섞인_경우() {
        // given
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber opponentNumber = new BaseballNumber(Arrays.asList(1, 3, 2));

        // when
        Hint result = playerNumber.compare(opponentNumber);

        // then
        assertEquals(1, result.getStrike(), "하나의 숫자만 스트라이크여야 함");
        assertEquals(2, result.getBall(), "두 개의 숫자가 볼이어야 함");
    }

    @Test
    void 낫싱인_경우() {
        // given
        BaseballNumber playerNumber = new BaseballNumber(Arrays.asList(1, 2, 3));
        BaseballNumber opponentNumber = new BaseballNumber(Arrays.asList(4, 5, 6));

        // when
        Hint result = playerNumber.compare(opponentNumber);

        // then
        assertEquals(0, result.getStrike(), "스트라이크가 없어야 함");
        assertEquals(0, result.getBall(), "볼이 없어야 함");
    }
}
