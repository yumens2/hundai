package BaseballGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ScoreEvaluatorTest {
    ScoreEvaluator scoreEvaluator = new ScoreEvaluator();

    @Test
    @DisplayName("getScore 메서드 테스트")
    void testGetScore() {
        List<String> guess = List.of("1", "2", "3");
        String answer = "132";

        List<Integer> score = scoreEvaluator.getScore(guess, answer);

        Assertions.assertEquals(1, score.get(0), "올바른 스트라이크 개수가 아닙니다.");
        Assertions.assertEquals(2, score.get(1), "올바른 볼 개수가 아닙니다.");
    }
}