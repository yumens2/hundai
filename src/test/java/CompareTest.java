
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CompareTest {

    @Test
    void testComparisonWithNoMatch() {
        // Given
        Compare compare = new Compare();
        int[] targetNumbers = {1, 2, 3};
        int[] playerInput = {4, 5, 6};

        compare.compare(targetNumbers, playerInput);
    }

    @Test
    void testComparisonWithSomeStrikes() {

        Compare compare = new Compare();
        int[] targetNumbers = {1, 2, 3};
        int[] playerInput = {1, 5, 6};

        compare.compare(targetNumbers, playerInput);

    }

    @Test
    void testComparisonWithSomeBalls() {
        // Given
        Compare compare = new Compare();
        int[] targetNumbers = {1, 2};
        int[] playerInput = {4, 1, 5};

        compare.compare(targetNumbers, playerInput);

    }

    @Test
    void testComparisonWithStrikesAndBalls() {
        Compare compare = new Compare();
        int[] targetNumbers = {1, 2, 3};
        int[] playerInput = {1, 4, 2};

        compare.compare(targetNumbers, playerInput);

    }

    @Test
    void testStrikeCount() {
        Compare compare = new Compare();
        int[] targetNumbers = {1, 2, 3};
        int[] playerInput = {1, 5, 6};

        compare.compare(targetNumbers, playerInput);

        assertThat(compare.strikeCount()).isEqualTo(1);
    }
}
