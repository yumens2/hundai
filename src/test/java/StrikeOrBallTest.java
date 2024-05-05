import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StrikeOrBallTest {

    @Test
    public void TestStrikeOrBall() {
        StrikeOrBall game = new StrikeOrBall();
        int[] target = {1, 2, 3};

        int[] guess1 = {3, 2, 1}; //  1 strike 3 ball
        int[] guess2 = {1, 4, 5}; // 1 strike 1 ball
        int[] guess3 = {4, 5, 6}; // 0 strike 0 ball

        int result1 = game.strike(target, guess1);
        int result2 = game.ball(target, guess1);
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(3);

        int result3 = game.strike(target, guess2);
        int result4 = game.ball(target, guess2);
        assertThat(result3).isEqualTo(1);
        assertThat(result4).isEqualTo(1);

        int result5 = game.strike(target, guess3);
        int result6 = game.ball(target, guess3);
        assertThat(result5).isEqualTo(0);
        assertThat(result6).isEqualTo(0);
    }
}

