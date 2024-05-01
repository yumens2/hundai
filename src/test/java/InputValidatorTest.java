import org.junit.jupiter.api.Test;
import util.InputValidator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
    @Test
    public void testValidateThreeUniqueNumbers() {
        // 세 개의 고유한 숫자로 구성된 문자열 테스트
        ArrayList<Integer> result1 = InputValidator.validateThreeUniqueNumbers("123");
        assertArrayEquals(new Integer[]{1, 2, 3}, result1.toArray(new Integer[0]));

        // 중복된 숫자가 있는 경우 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateThreeUniqueNumbers("122");
        });

        // 숫자가 아닌 문자가 있는 경우 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateThreeUniqueNumbers("1a2");
        });

        // 문자열 길이가 3이 아닌 경우 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateThreeUniqueNumbers("1234");
        });
    }

    @Test
    public void testValidateOneOrTwo() {
        // 1 또는 2인 경우 테스트
        int result1 = InputValidator.validateOneOrTwo("1");
        assertEquals(1, result1);

        int result2 = InputValidator.validateOneOrTwo("2");
        assertEquals(2, result2);

        // 1 또는 2가 아닌 경우 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateOneOrTwo("3");
        });

        // 문자열 길이가 1이 아닌 경우 테스트
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateOneOrTwo("12");
        });
    }
}
