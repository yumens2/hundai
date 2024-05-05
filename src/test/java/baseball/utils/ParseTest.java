package baseball.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParseTest {

    @Test
    void parseUserInputInvalidLength() {
        // 길이가 유효하지 않을 때 IllegalArgumentException을 던져야 합니다.
        Parse parse = new Parse();
        assertThrows(IllegalArgumentException.class, () -> parse.parseUserInput("12345", 3));
    }

    @Test
    void parseUserInputNonDigit() {
        // 입력에 숫자가 아닌 문자가 포함되어 있을 때 IllegalArgumentException을 던져야 합니다.
        Parse parse = new Parse();
        assertThrows(IllegalArgumentException.class, () -> parse.parseUserInput("12a4", 4));
    }

    @Test
    void parseUserInputValid() {
        // 정상적인 입력을 처리할 수 있어야 합니다.
        Parse parse = new Parse();
        assertArrayEquals(new int[]{1, 2, 3}, parse.parseUserInput("123", 3));
    }
}
