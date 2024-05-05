import baseball.domain.Ball;
import baseball.domain.BallType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @Test
    @DisplayName("타입의 상관 없이 볼의 숫자가 같을 시 동등성 검사를 통과한다.")
    void equalsTest() {
        //given
        Ball ball1 = new Ball( BallType.STRIKE,1);
        Ball ball2 = new Ball( BallType.BALL,1);
        //When @ Then
        assertThat(ball1).isEqualTo(ball2);
    }
}
