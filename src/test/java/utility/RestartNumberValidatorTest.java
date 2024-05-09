package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartNumberValidatorTest {

    @ParameterizedTest
    @DisplayName("올바른 Restart Number check 테스트")
    @ValueSource(strings = {"1", "2"})
    void checkRestartNumberCorrect(String inputNumber) {
        Assertions.assertDoesNotThrow(() -> RestartNumberValidator.checkRestartNumberCorrect(inputNumber));
    }

    @ParameterizedTest
    @DisplayName("잘못된 Restart Number check 테스트")
    @ValueSource(strings = {"3", "9", "12", "123", "123456789" ,"test", "t", "\n"})
    void checkRestartNumberIncorrect(String inputNumber) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> RestartNumberValidator.checkRestartNumberCorrect(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}