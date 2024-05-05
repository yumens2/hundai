package userinterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void validateGuess() {
        InputValidator inputValidator = new InputValidator();

        // input이 1-9가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("012"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("r12"));

        // input이 3자리가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("1234"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("12"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess(""));

        // 중복된 숫자가 있을 때
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("112"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("121"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateGuess("999"));

        // 정상인 케이스
        assertDoesNotThrow(() -> inputValidator.validateGuess("123"));
    }

    @Test
    void validateReplay() {
        InputValidator inputValidator = new InputValidator();

        // input이 1-2가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay("0"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay("3"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay("a"));

        // input이 1자리가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay("12"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay("123"));
        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateReplay(""));

        // 정상 케이스
        assertDoesNotThrow(() -> inputValidator.validateReplay("1"));
        assertDoesNotThrow(() -> inputValidator.validateReplay("2"));
    }
}