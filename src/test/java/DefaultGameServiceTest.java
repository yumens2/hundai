import baseball.domain.Ball;
import baseball.domain.BallType;
import baseball.service.DefaultGameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultGameServiceTest {
    @Test
    @DisplayName("getRandomNumber 메서드의 작동을 테스트한다.")
    void getRandomNumberTest() {
        //given
        DefaultGameService defaultGameService = new DefaultGameService();
        //When @ Then
        assertThat(defaultGameService.getRandomNumber()).isBetween(100, 999);
    }

    @Test
    @DisplayName("createPitching 메서드의 작동을 테스트한다.")
    void createPitchingTest() {
        //given
        DefaultGameService defaultGameService = new DefaultGameService();
        List<Ball> answer = List.of(new Ball(BallType.NOTHING, 3), new Ball(BallType.NOTHING, 2), new Ball(BallType.NOTHING, 1));
        //When @ Then
        assertThat(defaultGameService.createPitching("123", answer).toString()).isEqualTo("3스트라이크");
    }
}
