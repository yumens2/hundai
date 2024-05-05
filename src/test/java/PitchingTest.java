import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.domain.Pitching;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PitchingTest {

    @Test
    @DisplayName("toString 메서드의 작동을 테스트한다.")
    void toStringTest() {
        //given
        Pitching pitching = new Pitching(List.of(new Ball(BallType.STRIKE, 1), new Ball(BallType.BALL, 2), new Ball(BallType.STRIKE, 3)));
        //When @ Then
        assertThat(pitching.toString()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    @DisplayName("isThreeStrike 메서드의 작동을 테스트한다.")
    void isThreeStrikeTest() {
        //given
        Pitching pitching = new Pitching(List.of(new Ball(BallType.STRIKE, 1), new Ball(BallType.STRIKE, 2), new Ball(BallType.STRIKE, 3)));
        //When @ Then
        assertThat(pitching.isThreeStrike()).isTrue();
    }

}
