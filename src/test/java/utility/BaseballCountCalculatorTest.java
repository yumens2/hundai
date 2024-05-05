package utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BaseballCountCalculatorTest {

    private static Stream<Arguments> provideActualBallArguments() {
        return Stream.of(
                Arguments.of("123", "456", 0),
                Arguments.of("123", "231", 3),
                Arguments.of("123", "124", 0),
                Arguments.of("123", "145", 0),
                Arguments.of("123", "342", 2),
                Arguments.of("123", "536", 1),
                Arguments.of("123", "987", 0)
        );
    }

    private static Stream<Arguments> provideBallArguments() {
        return Stream.of(
                Arguments.of("123", "456", 0),
                Arguments.of("123", "231", 3),
                Arguments.of("123", "124", 2),
                Arguments.of("123", "145", 1),
                Arguments.of("123", "342", 2),
                Arguments.of("123", "536", 1),
                Arguments.of("123", "987", 0)
        );
    }

    private static Stream<Arguments> provideStrikeArguments() {
        return Stream.of(
                Arguments.of("123", "456", 0),
                Arguments.of("123", "231", 0),
                Arguments.of("123", "342", 0),
                Arguments.of("123", "536", 0),
                Arguments.of("123", "987", 0),
                Arguments.of("123", "123", 3),
                Arguments.of("123", "423", 2),
                Arguments.of("123", "124", 2),
                Arguments.of("123", "153", 2),
                Arguments.of("123", "145", 1),
                Arguments.of("123", "625", 1),
                Arguments.of("123", "763", 1)
        );
    }

    @ParameterizedTest
    @DisplayName("실제 볼카운트 계산 확인 테스트")
    @MethodSource("provideActualBallArguments")
    void countBallExceptForStrike(String aNumber, String bNumber, int ballCount) {
        int ballCountResult = BaseballCountCalculator.countBall(aNumber, bNumber);
        int strikeCount = BaseballCountCalculator.countStrike(aNumber, bNumber);
        ballCountResult = BaseballCountCalculator.countBallExceptForStrike(ballCountResult, strikeCount);
        Assertions.assertThat(ballCountResult).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @DisplayName("볼카운트 계산 확인 테스트")
    @MethodSource("provideBallArguments")
    void countBall(String aNumber, String bNumber, int ballCount) {
        int ballCountResult = BaseballCountCalculator.countBall(aNumber, bNumber);
        Assertions.assertThat(ballCountResult).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @DisplayName("스트라이크 카운트 계산 확인 테스트")
    @MethodSource("provideStrikeArguments")
    void countStrike(String aNumber, String bNumber, int strikeCount) {
        int strikeCountResult = BaseballCountCalculator.countStrike(aNumber, bNumber);
        Assertions.assertThat(strikeCountResult).isEqualTo(strikeCount);
    }
}