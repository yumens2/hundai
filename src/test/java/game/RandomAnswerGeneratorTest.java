package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomAnswerGeneratorTest {

    RandomAnswerGenerator gen = new RandomAnswerGenerator();

    @DisplayName("랜덤 정답 생성 테스트")
    @Test
    public void testRandomAnswerGenerator() {
        String answer = gen.getAnswerAsString();
        assertEquals(GameParameters.nDigit, answer.length(),
            "생성된 정답의 길이가 GameParameters.nDigit과 다름");
        assertNotEquals(answer.charAt(0), answer.charAt(1));
        assertNotEquals(answer.charAt(1), answer.charAt(2));
    }

}
