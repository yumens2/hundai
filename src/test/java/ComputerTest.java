import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerTest {

    @Test
    void testComputerRandomNumbers() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.getComputerNumbers();

        assertThat(numbers).hasSize(3);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertThat(uniqueNumbers).hasSize(3);

        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}
