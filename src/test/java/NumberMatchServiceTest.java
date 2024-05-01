import org.junit.jupiter.api.Test;
import service.NumberMatchService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberMatchServiceTest {
    @Test
    public void testIsMatch() {
        //컴퓨터 숫자들!
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);

        // 스트라이크 3일 때
        List<Integer> userNumbers1 = Arrays.asList(1, 2, 3);
        assertTrue(NumberMatchService.isMatch(computerNumbers, userNumbers1));

        // 스트라이크 1, 볼 2일 때
        List<Integer> userNumbers2 = Arrays.asList(1, 3, 2);
        assertFalse(NumberMatchService.isMatch(computerNumbers, userNumbers2));

        // 스트라이크 1, 볼 1일 때
        List<Integer> userNumbers3 = Arrays.asList(1, 3, 4);
        assertFalse(NumberMatchService.isMatch(computerNumbers, userNumbers3));

        // 볼 2 스트라이크2
        List<Integer> userNumbers4 = Arrays.asList(3, 2, 1);
        assertFalse(NumberMatchService.isMatch(computerNumbers, userNumbers4));

        // 스트라이크 2
        List<Integer> userNumbers5 = Arrays.asList(1, 2, 4);
        assertFalse(NumberMatchService.isMatch(computerNumbers, userNumbers5));


        // 아무것도 없을 때
        List<Integer> userNumbers6 = Arrays.asList(4, 5, 6);
        assertFalse(NumberMatchService.isMatch(computerNumbers, userNumbers6));
    }
}
