package view;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
import exception.InvalidRestartStateException;
import exception.NonNumericValueException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    public InputStream originalIn;

    @BeforeEach
    void setUpStreams() {
        originalIn = System.in;
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
    }

    @Test
    void askNumber_normal_case() {
        // given
        String input = "123";
        systemIn(input);

        // when
        String result = InputView.askNumber();

        // then
        assertEquals("123", result);
    }

    @Test
    void askNumber_non_numeric_value() {
        // given
        String input = "0bc";
        systemIn(input);

        // then
        // exception
        assertThrows(NonNumericValueException.class, () -> {
            InputView.askNumber();
        });
    }

    @Test
    void askNumber_invalid_length() {
        // given
        String input = "1234";
        systemIn(input);

        assertThrows(InvalidLengthException.class, () -> {
            InputView.askNumber();
        });
    }

    @Test
    void askNumber_duplicate_number() {
        // given
        String input = "112";
        systemIn(input);

        assertThrows(DuplicateNumberException.class, () -> {
            InputView.askNumber();
        });
    }

    @Test
    void askRestart_normal_case_true() {
        // given
        String input = "1";
        systemIn(input);

        // when
        // then
        assertTrue(InputView.askRestart());
    }

    @Test
    void askRestart_normal_case_false() {
        // given
        String input = "2";
        systemIn(input);

        // when
        // then
        assertFalse(InputView.askRestart());
    }

    @Test
    void askRestart_invalid_restart_state() {
        // given
        String input = "3";
        systemIn(input);

        // then
        // exception
        assertThrows(InvalidRestartStateException.class, () -> {
            InputView.askRestart();
        });
    }

    @Test
    void askRestart_non_numeric_value() {
        // given
        String input = "a";
        systemIn(input);

        // then
        // exception
        assertThrows(InvalidRestartStateException.class, () -> {
            InputView.askRestart();
        });
    }

    private void systemIn(String input) {
        String inputString = input + "\n";
        InputView.setScanner(new Scanner(new ByteArrayInputStream(inputString.getBytes())));
    }
}