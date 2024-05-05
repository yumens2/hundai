package start;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptOccurCheckTest {

    @Test
    void checkInputValidation() {
        assertDoesNotThrow(() -> ExceptOccurCheck.checkInputValidation("123"));
        assertDoesNotThrow(() -> ExceptOccurCheck.checkInputValidation("456"));
        assertDoesNotThrow(() -> ExceptOccurCheck.checkInputValidation("789"));

        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("012"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("1234"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("12"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("a12"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("a"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("^!@"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("112"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("11"));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation("111"));
    }

    @Test
    void testCheckInputValidation() {
        assertDoesNotThrow(() -> ExceptOccurCheck.checkInputValidation(1));
        assertDoesNotThrow(() -> ExceptOccurCheck.checkInputValidation(2));

        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation(0));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation(3));
        assertThrows(IllegalArgumentException.class, () -> ExceptOccurCheck.checkInputValidation(-1));

    }
}