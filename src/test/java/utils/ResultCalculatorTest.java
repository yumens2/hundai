package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {
    
    @Test
    @DisplayName("3스트라이크인 경우")
    void testCountStrike_3Strikes() {
        int[] answer = {1, 2, 3};
        int[] guess = {1, 2, 3};

        int result = ResultCalculator.countStrike(answer, guess);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("정답은 아니지만 스트라이크가 1개 이상인 경우")
    void testCountStrike_PartialStrikes() {
        int[] answer = {1, 2, 3};
        int[] guess = {1, 5, 3};

        int result = ResultCalculator.countStrike(answer, guess);

        assertEquals(2, result);
    }

    @Test
    @DisplayName("스트라이크가 없는 경우")
    void testCountStrike_NoStrikes() {
        int[] answer = {1, 2, 3};
        int[] guess = {4, 5, 6};

        int result = ResultCalculator.countStrike(answer, guess);

        assertEquals(0, result);
    }

    @Test
    @DisplayName("정답 숫자의 자리, 수 모두 알아내지 못한 경우")
    void testCountNotContain_AllNotContain() {
        int[] answer = {1, 2, 3};
        int[] guess = {4, 5, 6};

        int result = ResultCalculator.countNotContain(answer, guess);

        assertEquals(3, result);
    }

    @Test
    @DisplayName("일부 숫자만 자리, 수 모두 알아내지 못한 경우")
    void testCountNotContain_PartialNotContain() {
        int[] answer = {1, 2, 3};
        int[] guess = {1, 5, 6};

        int result = ResultCalculator.countNotContain(answer, guess);

        assertEquals(2, result);
    }
}
