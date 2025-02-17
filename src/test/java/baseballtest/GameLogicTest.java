package baseballtest;

import static org.assertj.core.api.Assertions.assertThat;
import baseball.GameLogic;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class GameLogicTest {
    @Test
    public void testCountStrikes() {
        GameLogic logic = new GameLogic();
        assertThat(logic.countStrikes("123", Arrays.asList(1, 2, 3))).isEqualTo(3);
        assertThat(logic.countStrikes("321", Arrays.asList(1, 2, 3))).isEqualTo(1);
        assertThat(logic.countStrikes("456", Arrays.asList(1, 2, 3))).isEqualTo(0);
    }

    @Test
    public void testCountBalls() {
        GameLogic logic = new GameLogic();
        assertThat(logic.countBalls("321", Arrays.asList(1, 2, 3), 1)).isEqualTo(2);
        assertThat(logic.countBalls("145", Arrays.asList(1, 2, 3), 1)).isEqualTo(0);
        assertThat(logic.countBalls("231", Arrays.asList(1, 2, 3), 0)).isEqualTo(3);
    }
}