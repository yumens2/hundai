import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UniqueDigits_test {
    @Test
    public void UniqueDigitsSubTest() {
        // 문자열 내 중복되는 문자가 하나라도 존재한다면 유효하지 않은 문자열
        String number = "12345";
        assertTrue(BaseballGame.UniqueDigits_sub(0, number));
        assertTrue(BaseballGame.UniqueDigits_sub(1, number));
        assertTrue(BaseballGame.UniqueDigits_sub(2, number));
        assertTrue(BaseballGame.UniqueDigits_sub(3, number));
        assertTrue(BaseballGame.UniqueDigits_sub(4, number));
    }

    @Test
    public void UniqueDigitsSubTest2() {
        // 문자열 내 중복되는 문자가 하나라도 존재한다면 유효하지 않은 문자열
        String number = "11234";
        assertFalse(BaseballGame.UniqueDigits_sub(0, number));
        assertTrue(BaseballGame.UniqueDigits_sub(1, number));
        assertTrue(BaseballGame.UniqueDigits_sub(2, number));
        assertTrue(BaseballGame.UniqueDigits_sub(3, number));
        assertTrue(BaseballGame.UniqueDigits_sub(4, number)); // 마지막 문자는 중복이 없으므로 true
    }

    @Test
    public void UniqueDigitsSubTest3() {
        // 문자열 내 중복되는 문자가 하나라도 존재한다면 유효하지 않은 문자열
        String number = "12234";
        assertTrue(BaseballGame.UniqueDigits_sub(0, number));
        assertFalse(BaseballGame.UniqueDigits_sub(1, number));
        assertTrue(BaseballGame.UniqueDigits_sub(2, number));
        assertTrue(BaseballGame.UniqueDigits_sub(3, number));
        assertTrue(BaseballGame.UniqueDigits_sub(4, number)); // 마지막 문자는 중복이 없으므로 true
    }

}
