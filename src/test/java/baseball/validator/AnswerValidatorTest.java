package baseball.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcd", "1234", "565", "908"})
    void 예외_발생_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            AnswerValidator.validate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "421"})
    void 정상_입력_테스트(String input) {
        assertDoesNotThrow(() -> AnswerValidator.validate(input));
    }
}