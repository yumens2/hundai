import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

class ResultCalculatorTest {
    @Test
    void calculateResult_WhenAllMatch_ShouldReturnThreeStrikes() {
        ResultCalculator calculator = new ResultCalculator();
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        String result = calculator.calculateResult(computerNumbers, "123");

        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void calculateResult_NoMatches_ShouldReturnNoting() {
        ResultCalculator calculator = new ResultCalculator();
        Set<Integer> computerNumbers = new LinkedHashSet<>();
        computerNumbers.add(4);
        computerNumbers.add(5);
        computerNumbers.add(6);
        String result = calculator.calculateResult(computerNumbers, "123");

        assertThat(result).isEqualTo("낫싱");
    }
}
