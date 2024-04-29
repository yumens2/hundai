package src.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberComparatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest(name = "숫자 비교 테스트 - {1}")
    @MethodSource("provideGuessNumbersAndExpectedOutput")
    @DisplayName("숫자 비교 테스트")
    void numberComparisonTest(int guess, String expectedOutput, Predicate<Boolean> predicate) {
        // given
        int answer = 123;

        // when
        boolean result = NumberComparator.compareNumber(answer, guess);

        // then
        assertTrue(predicate.test(result));
        assertEquals(expectedOutput + " \n", outContent.toString());
    }

    private static Stream<Arguments> provideGuessNumbersAndExpectedOutput() {
        return Stream.of(
                Arguments.of(456, "낫싱", Predicate.isEqual(false)),

                Arguments.of(312, "3볼", Predicate.isEqual(false)),
                Arguments.of(412, "2볼", Predicate.isEqual(false)),
                Arguments.of(452, "1볼", Predicate.isEqual(false)),

                Arguments.of(124, "2스트라이크", Predicate.isEqual(false)),
                Arguments.of(145, "1스트라이크", Predicate.isEqual(false)),

                Arguments.of(132, "2볼 1스트라이크", Predicate.isEqual(false)),
                Arguments.of(142, "1볼 1스트라이크", Predicate.isEqual(false)),

                Arguments.of(123, "3스트라이크", Predicate.isEqual(true))
        );
    }
}