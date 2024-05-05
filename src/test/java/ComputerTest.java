import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    public void testGenerateNumReturnsThreeNumbers() {
        List<Integer> numbers = Computer.generateNum();

        assertEquals(3, numbers.size(), "3개의 숫자를 반환해야 합니다.");
    }

    @Test
    public void testGenerateNumReturnsUniqueNumbers() {
        List<Integer> numbers = Computer.generateNum();
        long uniqueCount = numbers.stream().distinct().count();

        assertEquals(numbers.size(), uniqueCount, "모든 숫자는 중복이 아니어야 합니다.");
    }

    @Test
    public void testGenerateNumReturnsNumbersBetweenOneAndNine() {
        List<Integer> numbers = Computer.generateNum();
        boolean allMatch = numbers.stream().allMatch(num -> num >= 1 && num <= 9);

        assertTrue(allMatch, "모든 숫자는 1에서 9 사이어야 합니다.");
    }
}

