package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EvaluatorTest {

    static Evaluator evaluator;

    @BeforeAll
    static void initAll() {
        evaluator = new Evaluator();
        AnswerGenerator answerGenerator = new TestAnswerGenerator("123");
        evaluator.setAnswer(answerGenerator);
    }

    @DisplayName("evaluate / isCorrect 테스트")
    @Test
    public void evaluateTest() {
        Assertions.assertArrayEquals(new int[]{0, 0}, evaluator.evaluate("456"));
        Assertions.assertArrayEquals(new int[]{0, 1}, evaluator.evaluate("178"));
        Assertions.assertArrayEquals(new int[]{0, 2}, evaluator.evaluate("923"));
        Assertions.assertArrayEquals(new int[]{0, 3}, evaluator.evaluate("123"));
        Assertions.assertArrayEquals(new int[]{1, 0}, evaluator.evaluate("289"));
        Assertions.assertArrayEquals(new int[]{1, 1}, evaluator.evaluate("283"));
        Assertions.assertArrayEquals(new int[]{2, 1}, evaluator.evaluate("213"));
        Assertions.assertArrayEquals(new int[]{3, 0}, evaluator.evaluate("231"));
    }

    @DisplayName("isCorrect 테스트")
    @Test
    public void isCorrectTest() {
        evaluator.evaluate("123");
        Assertions.assertEquals(3, evaluator.getNStrike());
        Assertions.assertEquals(0, evaluator.getNBall());
    }
}
