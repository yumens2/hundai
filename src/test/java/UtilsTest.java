import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilsTest {

    @Test
    @DisplayName("숫자 분리 테스트")
    void getDigits() {
        int[] digits = Utils.getDigits(123);
        assertArrayEquals(new int[]{1, 2, 3}, digits);
        digits = Utils.getDigits(111);
        assertArrayEquals(new int[]{1, 1, 1}, digits);
        digits = Utils.getDigits(122);
        assertArrayEquals(new int[]{1, 2, 2}, digits);
    }

    @Test
    @DisplayName("숫자 유효성 검사 테스트 - 100~999 사이의 숫자가 아닌 경우")
    void validateNumber() {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(finalI));
        }
        for (int i = 1000; i < 1100; i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(finalI));
        }
    }

    @Test
    @DisplayName("숫자 유효성 검사 테스트 - 0을 포함한 숫자인 경우")
    void validateNumberWithZero() {
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(100));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(101));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(110));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(200));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(210));
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(201));
    }

    @ParameterizedTest
    @ValueSource(ints = {111, 121, 112, 211, 122, 212, 221})
    @DisplayName("중복 숫자 판별 여부 테스트")
    void validateNumberWithDuplicate(int number) {
        assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"q", "qqq", "qq23", "qwe", "1234", "12345", "123456"})
    @DisplayName("입력값 유효성 검사 테스트")
    void validateInputString(String input) {
        assertThrows(IllegalArgumentException.class, () -> Utils.InputToRightInteger(input));
    }
}