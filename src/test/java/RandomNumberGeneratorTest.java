import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void generateNumbers() {

        List<Integer> numbers = RandomNumberGenerator.generateNumbers();
        assertEquals(3, numbers.size());
        assertTrue(numbers.stream().allMatch(num -> num > 0 && num < 10));
        assertEquals(3, numbers.stream().distinct().count());
    }
}