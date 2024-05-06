package utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputCheckerTest {

    UserInputChecker userInputChecker = UserInputChecker.getUserInputChecker();

    @DisplayName("유저 응답 exception Throw 테스트")
    @Test
    public void throwExceptionWhenGetWrongInput() {
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidGuess("12?"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidGuess("012"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidGuess("1234"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidGuess("12"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidGuess(""));
    }

    @DisplayName("게임종료 후 유저 선택 exception Throw 테스트")
    @Test
    public void throwExceptionWhenGetWrongChoice() {
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidChoice("0"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidChoice("3"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidChoice("12"));
        assertThrows(IllegalArgumentException.class,
            () -> userInputChecker.isValidChoice("1-"));
    }
}
