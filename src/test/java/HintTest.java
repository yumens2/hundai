import static org.junit.jupiter.api.Assertions.assertEquals;

import constant.GameMessageConstant;
import data.GameResult;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void getHint_nothing() {
        Hint hint = new Hint(new GameResult(0, 0));
        assertEquals(hint.getHint(), GameMessageConstant.NOTHING);
    }

    @Test
    void getHint_onlyBall() {
        int ball = 1;
        Hint hint = new Hint(new GameResult(ball, 0));
        assertEquals(hint.getHint(), String.format("%d%s", ball, GameMessageConstant.BALL));
    }

    @Test
    void getHint_onlyStrike() {
        int strike = 3;
        Hint hint = new Hint(new GameResult(0, strike));
        assertEquals(hint.getHint(), String.format("%d%s", strike, GameMessageConstant.STRIKE));
    }

    @Test
    void getHint_ballAndStrike() {
        int ball = 1;
        int strike = 1;
        Hint hint = new Hint(new GameResult(ball, strike));
        assertEquals(hint.getHint(),
                String.format("%d%s %d%s", ball, GameMessageConstant.BALL, strike,
                        GameMessageConstant.STRIKE));
    }
}