package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BitValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "a", "z"})
    void 예외_발생_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BitValidator.validate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 정상_입력_테스트(String input) {
        assertDoesNotThrow(() -> BitValidator.validate(input));
    }
}