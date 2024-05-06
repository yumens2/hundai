import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Set;

class NumberGeneratorTest {
    @Test
    void generateRandomNumbers_ShouldGenerateThreeUniqueNumbersBetweenOneAndNine() {
        NumberGenerator generator = new NumberGenerator();
        Set<Integer> numbers = generator.generateRandomNumbers();

        assertThat(numbers).hasSize(3);
        assertThat(numbers).allMatch(num -> num >= 1 && num <= 9);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
