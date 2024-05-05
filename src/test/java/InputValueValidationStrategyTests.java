import camp.nextstep.edu.application.core.DefaultInputValueValidationStrategy;
import camp.nextstep.edu.application.core.InputValueValidationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValueValidationStrategyTests {

    private InputValueValidationStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new DefaultInputValueValidationStrategy();
    }

    @Test
    @DisplayName("입력값 검증 테스트")
    void validateInputValueTest() {
        String input = "123";

        assertThatCode(() -> strategy.validate(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 null인 경우 예외 발생")
    void validateInputValueWithNullTest() {
        String input = null;

        assertThatThrownBy(() -> strategy.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "12"})
    @DisplayName("입력값이 3자리가 아닌 경우 예외 발생")
    void validateInputValueWithInvalidLengthTest(String input) {

        assertThatThrownBy(() -> strategy.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3자리 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "111", "998"})
    @DisplayName("입력값이 1에서 9까지의 서로 다른 숫자가 아닌 경우 예외 발생")
    void validateInputValueWithDuplicatedNumberTest(String input) {

        assertThatThrownBy(() -> strategy.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 1에서 9까지의 서로 다른 숫자여야 합니다.");
    }
}
