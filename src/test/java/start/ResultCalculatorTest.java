package start;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

    @Test
    void calculateResult() {
        int[] compArr = {1, 2, 3};

        assertEquals("3스트라이크", ResultCalculator.calculateResult(compArr, "123"));
        assertEquals("2스트라이크", ResultCalculator.calculateResult(compArr, "124"));
        assertEquals("1스트라이크", ResultCalculator.calculateResult(compArr, "145"));
        assertEquals("3볼", ResultCalculator.calculateResult(compArr, "231"));
        assertEquals("2볼", ResultCalculator.calculateResult(compArr, "235"));
        assertEquals("1볼", ResultCalculator.calculateResult(compArr, "265"));
        assertEquals("1볼 1스트라이크", ResultCalculator.calculateResult(compArr, "135"));
        assertEquals("2볼 1스트라이크", ResultCalculator.calculateResult(compArr, "213"));
        assertEquals("낫싱", ResultCalculator.calculateResult(compArr, "456"));
    }
}