package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersTest {
    
    @Test
    @DisplayName("임의의 서로 다른 숫자 3개를 결정하는 기능 테스트")
    void testGenerateRandomNumbers() {
        int[] numbers = RandomNumbers.generateRandomNumbers();

        assertNotNull(numbers);

        assertEquals(3, numbers.length);

        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 9);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                assertNotEquals(numbers[i], numbers[j]);
            }
        }
    }
}
