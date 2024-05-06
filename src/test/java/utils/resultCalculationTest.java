package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class resultCalculationTest {
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
    @DisplayName("스트라이크가 1개 이상")
    void countStrikes() {
        int[] game = {1, 2, 3};
        int[] user = {1, 5, 3};
        int result = resultCalculation.countStrikes(game, user);
        assertEquals(2, result);
    }


    @Test
    @DisplayName("볼이 2개 이상")
    void countBall() {
        int[] game = {1, 2, 3};
        int[] user = {3, 5, 1};
        int result = resultCalculation.countBall(game, user);
        assertEquals(2, result);
    }
}