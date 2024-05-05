package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class InputNumberValidatorTest {

    private static Stream<Arguments> provideCorrectStringArguments() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("12", 2),
                Arguments.of("123", 3),
                Arguments.of("98765", 5),
                Arguments.of("123456789", 9),
                Arguments.of("test", 4)
        );
    }

    private static Stream<Arguments> provideIncorrectStringArguments() {
        return Stream.of(
                Arguments.of("1", 2),
                Arguments.of("12", 1),
                Arguments.of("123", 123),
                Arguments.of("98765", 3),
                Arguments.of("123456789", -1),
                Arguments.of("test", 3)
        );
    }

    @ParameterizedTest
    @DisplayName("올바른 문자열 길이 확인 테스트")
    @MethodSource("provideCorrectStringArguments")
    void checkStringLengthCorrect(String string, int stringLength) {
        Assertions.assertDoesNotThrow(() -> InputNumberValidator.checkStringLengthCorrect(string, stringLength));
    }

    @ParameterizedTest
    @DisplayName("잘못된 문자열 길이 확인 테스트")
    @MethodSource("provideIncorrectStringArguments")
    void checkStringLengthIncorrect(String string, int stringLength) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                InputNumberValidator.checkStringLengthCorrect(string, stringLength)
        );
    }

    @ParameterizedTest
    @DisplayName("숫자 문자열 확인 테스트")
    @ValueSource(strings = {"1", "23", "456", "7891", "123456789", "333", "1111", "99999"})
    void checkStringNumeric(String string) {
        Assertions.assertDoesNotThrow(() -> InputNumberValidator.checkStringNumeric(string));
    }

    @ParameterizedTest
    @DisplayName("숫자 아닌 문자열 확인 테스트")
    @ValueSource(strings = {"test", "one1", "1o2", "isTestNumber404", "if2else", "o", "11ll1l1l1ll1l1l"})
    void checkStringNotNumeric(String string) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> InputNumberValidator.checkStringNumeric(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("서로 다른 숫자 확인 테스트")
    @ValueSource(strings = {"123", "456", "789", "159", "268", "369", "987"})
    void checkDifferentDigitNumber(String string) {
        Assertions.assertDoesNotThrow(() -> InputNumberValidator.checkDifferentDigitNumber(string));
    }

    @ParameterizedTest
    @DisplayName("같은 숫자 존재 확인 테스트")
    @ValueSource(strings = {"11", "33", "99", "131", "555", "959", "1235678901"})
    void checkSameDigitNumber(String string) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> InputNumberValidator.checkDifferentDigitNumber(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("IllegalArgument 예외 발생 테스트")
    void raiseIllegalArgumentException() {
        org.assertj.core.api.Assertions.assertThatThrownBy(InputNumberValidator::raiseIllegalArgumentException)
                .isInstanceOf(IllegalArgumentException.class);
    }
}