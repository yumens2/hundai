package io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    private InputStream systemIn;

    @BeforeEach
    void setUp() {
        systemIn = System.in;
    }

    @AfterEach
    void restore() {
        System.setIn(systemIn);
    }
    
    @DisplayName("getInput(): Test for valid input")
    @Test
    void testGetInput() {
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] guess = Input.getInput();

        assertArrayEquals(new int[]{1, 2, 3}, guess);
    }

    @DisplayName("getInput(): Test for invalid input")
    @Test
    void testGetInputInvalidInput() {
        String input = "testinput\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.getInput();
        });

        assertEquals("숫자 3개를 입력해야 합니다.", exception.getMessage());
    }

    @DisplayName("getNewGame(): Test for valid input")
    @Test
    void testGetNewGame() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int choice = Input.getNewGame();

        assertEquals(1, choice);
    }

    @DisplayName("getNewGame(): Test for invalid input")
    @Test
    void testGetNewGameInvalidInput() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Input.getNewGame();
        });

        assertEquals("잘못된 입력입니다. 1 또는 2를 입력하세요.", exception.getMessage());
    }

}
