package view;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
import exception.InvalidRestartStateException;
import exception.NonNumericValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void askNumber_normal_case() {
        // given
        String input = "123";

        // when
        String result = InputView.askNumber(input);

        // then
        assertEquals("123", result);
    }

    @Test
    void askNumber_non_numeric_value() {
        // given
        String input = "0bc";

        // then
        // exception
        assertThrows(NonNumericValueException.class, () -> {
            InputView.askNumber(input);
        });
    }

    @Test
    void askNumber_invalid_length() {
        // given
        String input = "1234";

        assertThrows(InvalidLengthException.class, () -> {
            InputView.askNumber(input);
        });
    }

    @Test
    void askNumber_duplicate_number() {
        // given
        String input = "112";

        assertThrows(DuplicateNumberException.class, () -> {
            InputView.askNumber(input);
        });
    }

    @Test
    void askRestart_normal_case_true() {
        // given
        String input = "1";

        // when
        // then
        assertTrue(InputView.askRestart(input));
    }

    @Test
    void askRestart_normal_case_false() {
        // given
        String input = "2";

        // when
        // then
        assertFalse(InputView.askRestart(input));
    }

    @Test
    void askRestart_invalid_restart_state() {
        // given
        String input = "3";

        // then
        // exception
        assertThrows(InvalidRestartStateException.class, () -> {
            InputView.askRestart(input);
        });
    }

    @Test
    void askRestart_non_numeric_value() {
        // given
        String input = "a";

        // then
        // exception
        assertThrows(InvalidRestartStateException.class, () -> {
            InputView.askRestart(input);
        });
    }
}