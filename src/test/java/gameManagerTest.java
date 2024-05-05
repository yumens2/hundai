import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class gameManagerTest {

    @Test
    public void 난수길이테스트() {
        gameManager newGameManager = new gameManager();
        int[] generatedRandNum = newGameManager.generateRand();

        assertEquals(generatedRandNum.length, 3);
    }
}
