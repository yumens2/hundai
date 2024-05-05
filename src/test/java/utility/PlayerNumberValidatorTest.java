package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNumberValidatorTest {

    @ParameterizedTest
    @DisplayName("올바른 Player Number check 테스트")
    @ValueSource(strings = {"123", "456", "789", "159", "429", "726", "987"})
    void checkPlayerNumberCorrect(String inputNumber) {
        Assertions.assertDoesNotThrow(() -> PlayerNumberValidator.checkPlayerNumberCorrect(inputNumber));
    }

    @ParameterizedTest
    @DisplayName("잘못된 Player Number check 테스트")
    @ValueSource(strings = {"1", "2", "9", "12", "23", "55", "99", "112", "012", "402", "999", "1234", "123456789", "test", "tes", "te", "t"})
    void checkPlayerNumberIncorrect(String inputNumber) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> PlayerNumberValidator.checkPlayerNumberCorrect(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}