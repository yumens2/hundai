import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class BaseballGameTest {

    private static BaseballGame game;

    @BeforeAll
    public static void setUp() {
        game = new BaseballGame();

        game.computerNumbers.clear();
        game.computerNumbers.addAll(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testBallOrStrike_AllStrikes() {
        Assertions.assertTrue(game.ballOrStrike("123"));
    }

    @Test
    public void testBallOrStrike_NoMatch() {
        Assertions.assertFalse(game.ballOrStrike("456"));
    }

    @Test
    public void testBallOrStrike_InvalidInputLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.ballOrStrike("12");
        });
    }

    @Test
    public void testBallOrStrike_InvalidInputValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.ballOrStrike("018");
        });
    }
}
