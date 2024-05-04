import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("숫자 유효성 검사 테스트")
    void validateNumber(){
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(finalI));
        }
        for (int i = 1000; i < 1100; i++) {
            int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> Utils.validateNumber(finalI));
        }
    }
}