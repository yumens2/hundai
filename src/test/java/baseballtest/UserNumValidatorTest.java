package baseballtest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import baseball.UserNumValidator;
import org.junit.jupiter.api.Test;

public class UserNumValidatorTest {
    @Test
    public void testIsValidInput_Valid() {
        UserNumValidator validator = new UserNumValidator();
        assertThat(validator.isValidInput("123")).isTrue();
    }

    @Test
    public void testIsValidInput_Invalid_NotUniqueDigits() {
        UserNumValidator validator = new UserNumValidator();
        assertThatThrownBy(() -> validator.isValidInput("112"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("All digits must be unique");
    }

    @Test
    public void testIsValidInput_Invalid_ContainsZero() {
        UserNumValidator validator = new UserNumValidator();
        assertThatThrownBy(() -> validator.isValidInput("105")).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("0 is not allowed");
    }

    @Test
    public void testIsValidInput_Invalid_Length() {
        UserNumValidator validator = new UserNumValidator();
        assertThatThrownBy(() -> validator.isValidInput("12")).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("three-digit number");
    }
}