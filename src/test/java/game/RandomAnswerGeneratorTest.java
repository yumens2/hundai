package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomAnswerGeneratorTest {

    RandomAnswerGenerator gen = new RandomAnswerGenerator();
    @DisplayName("랜덤 정답 생성 테스트")
    @Test
    public void testRandomAnswerGenerator() {
        assertEquals(GameParameters.nDigit, gen.getAnswerAsString().length(),
            "생성된 정답의 길이가 GameParameters.nDigit과 다름");
    }

}
