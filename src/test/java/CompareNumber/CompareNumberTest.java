package CompareNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CompareNumberTest {

    static Stream<Arguments> generateData(){
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), 2, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), 1, 2),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 2), 1, 1),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), 0, 0),
            Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), 0, 3)
        );
    }

    @DisplayName("Strike Test")
    @ParameterizedTest
    @MethodSource("generateData")
    void strikeTest(List<Integer> generatedNumbers, List<Integer> input, int expectedStrike, int expectedBall) {
        int result = CompareNumber.strike(generatedNumbers, input);
        assertEquals(expectedStrike, result);
    }

    @DisplayName("Ball Test")
    @ParameterizedTest
    @MethodSource("generateData")
    void ballTest(List<Integer> generatedNumbers, List<Integer> input, int expectedStrike, int expectedBall) {
        int result = CompareNumber.ball(generatedNumbers, input);
        assertEquals(expectedBall, result);
    }
}