import baseball.utils.GenerateRandomNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @Test
    public void testGenerage() {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
        List<Integer> generatedNumber = generateRandomNumber.generate();

        assertThat(generatedNumber).hasSize(GenerateRandomNumber.LENGTH);

        for (int number : generatedNumber) {
            assertThat(number).isGreaterThanOrEqualTo(GenerateRandomNumber.MIN_NUMBER)
                .isLessThanOrEqualTo(GenerateRandomNumber.MAX_NUMBER);

        }

        assertThat(generatedNumber).doesNotHaveDuplicates();
    }

}
