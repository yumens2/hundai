package CompareNumber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CompareNumberTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), 2, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 1, 2),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 2), 1, 1),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), 0, 3)
        );
    }

    @DisplayName("Strike Ball Test")
    @ParameterizedTest
    @MethodSource("generateData")
    void strikeBallTest(List<Integer> generatedNumbers, List<Integer> input, int strike, int ball) {
        int strikeCount = CompareNumber.strike(generatedNumbers, input);
        int ballCount = CompareNumber.ball(generatedNumbers, input);
        assertAll(
            () -> assertEquals(strike, strikeCount),
            () -> assertEquals(ball, ballCount)
        );
    }
}