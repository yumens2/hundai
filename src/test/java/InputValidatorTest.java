import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    @Test
    void validateInput_ValidInput_ShouldNotThrowException() {
        InputValidator validator = new InputValidator();
        assertThatCode(() -> validator.validateInput("123")).doesNotThrowAnyException();
    }

    @Test
    void validateInput_InvalidInput_ShouldThrowIllegalArgumentException() {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateInput("112")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 숫자는 서로 달라야 합니다.");
        assertThatThrownBy(() -> validator.validateInput("abc")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 9까지의 숫자여야 합니다.");
    }
}
