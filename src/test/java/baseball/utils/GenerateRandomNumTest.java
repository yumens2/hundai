package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenerateRandomNumTest {

    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void testGetRandomNumbers() {
        int size = 3;
        int[] numbers = GenerateRandomNum.getRandomNumbers(size, 1, 9);

        assertEquals(size, numbers.length);
        assertTrue(numbers[0] != numbers[1]);
        assertTrue(numbers[1] != numbers[2]);
        assertTrue(numbers[0] != numbers[2]);
    }
}