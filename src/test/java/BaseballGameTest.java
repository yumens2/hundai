import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    public void testThreeStrikes() {
        int[] comparedResult = {3, 0};
        String expectedMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertEquals(expectedMessage, baseballGame.getResultMessage(comparedResult));
    }

    @Test
    public void testNoStrikesNoBalls() {
        int[] comparedResult = {0, 0};
        String expectedMessage = "낫싱";
        assertEquals(expectedMessage, baseballGame.getResultMessage(comparedResult));
    }

    @Test
    public void testNoStrikesWithBalls() {
        int[] comparedResult = {0, 2};
        String expectedMessage = "2볼";
        assertEquals(expectedMessage, baseballGame.getResultMessage(comparedResult));
    }

    @Test
    public void testStrikesWithNoBalls() {
        int[] comparedResult = {2, 0};
        String expectedMessage = "2스트라이크";
        assertEquals(expectedMessage, baseballGame.getResultMessage(comparedResult));
    }

    @Test
    public void testStrikesWithBalls() {
        int[] comparedResult = {1, 2};
        String expectedMessage = "2볼 1스트라이크";
        assertEquals(expectedMessage, baseballGame.getResultMessage(comparedResult));
    }
}
