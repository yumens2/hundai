package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UmpireTest {

    private Umpire umpire;

    private static Stream<Arguments> provideNumberAndBallCountArguments() {
        return Stream.of(
                Arguments.of("123", "456", 0, 0),
                Arguments.of("123", "356", 1, 0),
                Arguments.of("123", "352", 2, 0),
                Arguments.of("123", "312", 3, 0),
                Arguments.of("123", "159", 0, 1),
                Arguments.of("123", "173", 0, 2),
                Arguments.of("123", "123", 0, 3)
        );
    }

    @BeforeEach
    void setUp() {
        umpire = new Umpire();
    }

    @ParameterizedTest
    @DisplayName("불카운트 계산 결과 확인 테스트")
    @MethodSource("provideNumberAndBallCountArguments")
    void setBaseballCountWithCalculator(String playerNumber, String answerNumber, int ballCount, int strikeCount) {
        umpire.setBaseballCountWithCalculator(playerNumber, answerNumber);
        BaseballCount baseballCount = umpire.getBaseballCount();
        Assertions.assertTrue(baseballCount.getBallCount() == ballCount && baseballCount.getStrikeCount() == strikeCount);
    }

    @Test
    @DisplayName("게임 승리 확인 테스트")
    void isPlayerWon() {
        umpire.setBaseballCountWithCalculator("123", "123");
        Assertions.assertTrue(umpire.isPlayerWon());
    }

    @Test
    @DisplayName("게임 패배 확인 테스트")
    void isPlayerLose() {
        umpire.setBaseballCountWithCalculator("123", "132");
        Assertions.assertFalse(umpire.isPlayerWon());
    }
}