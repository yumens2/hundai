package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import baseball.test.FixedAnswerGenerator;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OpponentTest {

    @Test
    @DisplayName("상대방을 정상적으로 생성한다.")
    void createOpponent() throws Exception {
        // given, when
        final Opponent opponent = Opponent.from(new RandomAnswerGenerator());

        final Class<? extends Opponent> clazz = opponent.getClass();
        final Field field = clazz.getDeclaredField("answers");
        field.setAccessible(true);
        final List<Integer> reflectionNumbers = (List<Integer>) field.get(opponent);

        // then
        assertThat(reflectionNumbers).hasSize(3);
    }

    @Test
    @DisplayName("힌트를 정상적으로 생성한다.")
    void checkHint() {
        // given
        final Opponent opponent = Opponent.from(new FixedAnswerGenerator());
        final List<Integer> userNumbers = List.of(1, 2, 3);

        // when
        final Hint hint = opponent.checkHint(userNumbers);

        // then
        final int strike = hint.getStrike();
        final int ball = hint.getBall();
        assertSoftly(softly -> {
            softly.assertThat(strike).isEqualTo(1);
            softly.assertThat(ball).isEqualTo(1);
        });
    }
}
