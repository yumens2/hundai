package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class makeRandomNumberTest {
    private InputStream systemIn;

    @BeforeEach
    void setUp() {
        systemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    @DisplayName(" 랜덤 숫자 생성 ")
    void getRandomNumbers() {
        int[] numbers = makeRandomNumber.getRandomNumbers();
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