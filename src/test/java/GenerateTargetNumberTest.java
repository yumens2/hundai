import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GenerateTargetNumberTest {

    @Test
    void testConstructor() {
        GenerateTargetNumber generator = new GenerateTargetNumber();
        int[] targetNumbers = generator.getTargetNumbers();

        assertThat(targetNumbers).isNotNull();

        assertThat(targetNumbers).hasSize(3);

        for (int num : targetNumbers) {
            assertThat(num).isBetween(1, 9);
        }

        assertThat(targetNumbers).doesNotHaveDuplicates();
    }
}