import org.junit.jupiter.api.Test;
import service.RandomNumberService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RandomNumberServiceTest {

    @Test
    public void testGetThreeUniqueNumbers() {
        List<Integer> numbers = RandomNumberService.getThreeUniqueNumbers();

        // 리스트의 크기가 3인지 테스트
        assertEquals(3, numbers.size(), "세 개의 숫자를 가져와야 합니다.");

        // 각 숫자가 1 이상 9 이하인지 테스트
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 9, "숫자는 1 이상 9 이하이어야 합니다.");
        }

        // 모든 숫자가 서로 다른지 테스트
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                assertNotEquals(numbers.get(i), numbers.get(j), "모든 숫자는 서로 달라야 합니다.");
            }
        }
    }
}
