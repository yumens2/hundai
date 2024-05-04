package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BitValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "3", "a", "z"})
    @DisplayName("예외 발생 테스트")
    void 예외_발생_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BitValidator.validate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("정상 입력 테스트")
    void 정상_입력_테스트(String input) {
        assertDoesNotThrow(() -> BitValidator.validate(input));
    }
}