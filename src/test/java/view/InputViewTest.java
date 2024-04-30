package view;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
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
}