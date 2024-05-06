package game.BaseballGame.validator;

import game.gamePack.BaseballGame.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {


    @Test
    @DisplayName("옳바른 숫자 게임 입력값 인지 확인합니다.")
    public void validGuessNumber() {
        // given
        String input = "123";
        String input2 = "abc";
        String input3 = "1234";
        String input4 = "000";

        // when
        Validator.validGuessNumber(input);

        // then
        Assertions.assertDoesNotThrow(() -> Validator.validGuessNumber(input));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.validGuessNumber(input2));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.validGuessNumber(input3));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.validGuessNumber(input4));
    }

    @Test
    @DisplayName("입력값이 1 또는 2인지 확인 illegalArgumentException을 던집니다.")
    public void validRestart() {
        // given
        String input = "1";
        String input2 = "2";
        String input3 = "3";
        String input4 = "a";

        // when
        Validator.validRestart(input);

        // then
        Assertions.assertDoesNotThrow(() -> Validator.validRestart(input));
        Assertions.assertDoesNotThrow(() -> Validator.validRestart(input2));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.validRestart(input3));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> Validator.validRestart(input4));
    }


}
