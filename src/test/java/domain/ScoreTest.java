package domain;


import domain.wrapper.Ball;
import domain.wrapper.Strike;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreTest {

    @Test
    void Score점수를_제대로_저장할_수_있다() {
        // given
        Strike strike = new Strike(2);
        Ball ball = new Ball(1);

        // when
        Score score = Score.create(strike, ball);

        // then
        Assertions.assertThat(score.getStrke().getCount()).isEqualTo(2);
        Assertions.assertThat(score.getBall().getCount()).isEqualTo(1);
    }
}