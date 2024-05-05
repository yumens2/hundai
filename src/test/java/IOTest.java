import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IOTest {
    // 사용자의 입력 값이 적절한지에 대한 테스트
    // 중복, 숫자 개수, 숫자가 아닌 다른 형태의 문자
    @Test
    void testIO() {
        BallCount ballCount = new BallCount();
        assertTrue(ballCount.isValidInput("123"));
        assertFalse(ballCount.isValidInput("112"));
        assertFalse(ballCount.isValidInput("12"));
        assertFalse(ballCount.isValidInput("abc"));
        assertFalse(ballCount.isValidInput("1234"));
        assertFalse(ballCount.isValidInput("12a"));
    }

}
