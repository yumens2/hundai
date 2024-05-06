import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void generate_lengthCheck_true() {
        int length = 3;
        int[] result = RandomNumberGenerator.generate(length);
        assertEquals(result.length, length);
    }

    @Test
    void generate_duplicateCheck_true() {
        int length = 3;
        Set<Integer> numbers = new HashSet<>();
        int[] result = RandomNumberGenerator.generate(length);
        for (int i : result) {
            numbers.add(i);
        }
        assertEquals(numbers.size(), length);
    }

}