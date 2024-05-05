import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    @Test
    //check ball and strike num and decide resume game
    void gameResultBallStrike() {
        GameState game = new GameState();
        int[] a = {1, 1};
        assertEquals(game.gameResult(a), 0);
    }

    @Test
    //check out and decide resume game
    void gameResultOut() {
        GameState game = new GameState();
        int[] a = {0, 0};
        assertEquals(game.gameResult(a), 0);
    }
}