package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomAnswerGeneratorTest {

    @Test
    @DisplayName("난수 생성기는 서로 3자리 다른 수를 생성해야한다.")
    void createDifferentDigits() {
        // given
        final RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();

        // when
        final List<Integer> answers = randomAnswerGenerator.generate();

        // then
        final long count = answers.stream().distinct().count();
        assertThat(count).isEqualTo(3);
    }
}
