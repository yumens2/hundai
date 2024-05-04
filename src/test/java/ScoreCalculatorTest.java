import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

    @Test
    void calculateScore() {
        List<Integer> userNumbers = Arrays.asList(1, 2, 3);
        List<Integer> computerNumbers = Arrays.asList(3, 1, 2);
        int[] score = ScoreCalculator.calculateScore(userNumbers, computerNumbers);
        assertEquals(0, score[0]);
        assertEquals(3, score[1]);

    }
}