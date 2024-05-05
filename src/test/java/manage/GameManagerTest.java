package manage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @Test
    void checkValidValuesWithCorrectInput() {
        String input = "123";
        assertDoesNotThrow(() -> gameManager.checkValidValues(input));
    }

    @Test
    void checkValidValuesWithIncorrectLength() {
        String input = "12";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameManager.checkValidValues(input));
        assertTrue(exception.getMessage().contains("숫자가 세자리수가 아닙니다."));
    }

    @Test
    void checkValidValuesWithOutOfRangeNumber() {
        String input = "008";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameManager.checkValidValues(input));
        assertTrue(exception.getMessage().contains("숫자가 범위안에 있지 않습니다."));
    }

    @Test
    void checkValidValuesWithDuplicateNumbers() {
        String input = "112";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> gameManager.checkValidValues(input));
        assertTrue(exception.getMessage().contains("중복된 숫자가 있습니다."));
    }
}
