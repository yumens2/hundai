package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("humanInput 유효값 입력 테스트")
    void humanInputWithValidInputTest() {
        //given
        String input = "123";

        //Then
        assertDoesNotThrow(() ->InputValidator.validateHumanValues(input));
    }

    @Test
    @DisplayName("humanInput 숫자가 아닌 값이 포함되어있을 경우 테스트")
    void humanInputWithIncludingNoNumberTypeTest(){
        //given
        String input = "12-5";

        //Then
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateHumanValues(input));
        assertEquals(e.getMessage(), "Input Type이 [1-9] 사이의 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("humanInput 0이 포함되어 있을 경우 테스트")
    void humanInputWithIncludingZeroNumberTest(){
        //given
        String input = "1205";

        //Then
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateHumanValues(input));
        assertEquals(e.getMessage(), "Input Type이 [1-9] 사이의 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("humnInput에 중복된 값이 포함되어 있을 경우 테스트")
    void humanInputWithDuplicatedNumberTest(){
        //given
        String input = "131";

        //Then
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateHumanValues(input));
        assertEquals(e.getMessage(), "Input 값 중 중복값이 존재합니다.");
    }
    @Test
    @DisplayName("gameType 유효값 입력 테스트")
    void gameTypeWithValidInputTest() {
        //given
        String input = "0";

        //Then
        assertDoesNotThrow(() -> InputValidator.validateGameType(input));
    }

    @Test
    @DisplayName("gameType 숫자형이 아닐 경우 테스트")
    void validateGameType() {
        //given
        String input = "-";

        //Then
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateGameType(input));
        assertEquals(e.getMessage(), "게임 시작 메뉴 입력이 숫자형이 아닙니다.");
    }
}