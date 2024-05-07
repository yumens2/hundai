package baseball.game;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @Test
    public void testIsValidInput_Valid() {
        assertThat(InputValidator.isValidInput("123")).isTrue();
    }

    @Test
    public void testIsValidInput_InvalidLength() {
        assertThat(InputValidator.isValidInput("12")).isFalse();
    }

    @Test
    public void testIsValidInput_ContainsNonDigit() {
        assertThat(InputValidator.isValidInput("1a3")).isFalse();
    }

    @Test
    public void testIsValidInput_ContainsZero() {
        assertThat(InputValidator.isValidInput("103")).isFalse();
    }

    @Test
    public void testIsValidInput_DuplicateDigits() {
        assertThat(InputValidator.isValidInput("112")).isFalse();
    }

}