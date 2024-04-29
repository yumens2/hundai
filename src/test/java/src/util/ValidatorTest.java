package src.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static src.util.Validator.validateGuessNumber;
import static src.util.Validator.validateOptionNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("숫자 예측 입력 예외처리 - 자릿수")
    void invalidUserInput_Length_Exception() {
        //given
        String userInputStr = "23";

        //when

        //then
        assertThatThrownBy(() -> validateGuessNumber(userInputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3자리 숫자여야 합니다.");
    }

    @Test
    @DisplayName("숫자 예측 입력 예외처리 - 문자열")
    void invalidUserInput_String_Exception() {
        //given
        String userInputStr = "abc";

        //when

        //then
        assertThatThrownBy(() -> validateGuessNumber(userInputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("숫자 예측 입력 예외처리 - 중복값")
    void invalidUserInput_Duplicate_Exception() {
        //given
        String userInputStr = "112";

        //when

        //then
        assertThatThrownBy(() -> validateGuessNumber(userInputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 있습니다.");
    }

    @Test
    @DisplayName("게임 추가진행 여부 입력 예외처리 - 문자열")
    void invalidUserInput_GameState_String_Exception() {
        //given
        String userInputStr = "abc";

        //when

        //then
        assertThatThrownBy(() -> validateOptionNumber(userInputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("게임 추가진행 여부 입력 예외처리 - 범위 벗어남")
    void invalidUserInput_GameState_OutOfBoundary_Exception() {
        //given
        String userInputStr = "3";

        //when

        //then
        assertThatThrownBy(() -> validateOptionNumber(userInputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 값이 적절하지 않습니다. [1,2] 중에 선택해주세요.");
    }
}