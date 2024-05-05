package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @DisplayName("서로 다른 숫자로 이루어진 3자리 수가 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a23", "111", "1234"})
    void 추측번호가_잘못된값이면_예외발생(String number) {
        assertThatThrownBy(() -> inputValidator.validateNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 또는 2가 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "a", "22"})
    void 재시작여부가_잘못된값이면_예외발생(String menuCode) {
        assertThatThrownBy(() -> inputValidator.validateGameMenuCode(menuCode))
            .isInstanceOf(IllegalArgumentException.class);
    }
}