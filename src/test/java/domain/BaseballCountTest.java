package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballCountTest {

    BaseballCount baseballCount;

    @BeforeEach
    void setUp() {
        baseballCount = new BaseballCount();
    }

    @Test
    @DisplayName("저장된 BaseballCount 값 확인 테스트")
    void setBaseballCount() {
        int ballCount = 2;
        int strikeCount = 1;
        baseballCount.setBaseballCount(ballCount, strikeCount);
        Assertions.assertTrue(baseballCount.getBallCount() == ballCount && baseballCount.getStrikeCount() == strikeCount);
    }

    @Test
    @DisplayName("BaseballCount 낫싱 확인 테스트")
    void isNothingCount() {
        baseballCount.setBaseballCount(0, 0);
        Assertions.assertTrue(baseballCount.isNothingCount());
    }

    @Test
    @DisplayName("BaseballCount 노 낫싱 확인 테스트")
    void isNotNothingCount() {
        baseballCount.setBaseballCount(3, 0);
        Assertions.assertFalse(baseballCount.isNothingCount());
    }
}