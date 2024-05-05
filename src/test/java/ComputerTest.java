import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ComputerTest {
    @Test
    void testNumberGeneration() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers).hasSize(3);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(num -> num > 0 && num < 10);
    }
}
