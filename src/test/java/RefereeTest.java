import static org.assertj.core.api.Assertions.assertThat;

import baseball.Referee;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    @DisplayName("볼 확인")
    @Test
    void ball(){
        Referee referee = new Referee();
        assertThat(referee.ball(Arrays.asList(1,3,5),Arrays.asList(5,3,1))).isEqualTo(3);
    }
    @DisplayName("스트라이크 확인")
    @Test
    void strike(){
        Referee referee = new Referee();
        assertThat(referee.strike(Arrays.asList(2,4,6),Arrays.asList(6,4,2))).isEqualTo(1);
    }
}
