import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class gameManagerTest {

    @Test
    public void 난수길이테스트() {
        gameManager newGameManager = new gameManager();
        int[] generatedRandNum = newGameManager.generateRand();

        assertEquals(generatedRandNum.length, 3);
    }

    @Test
    public void 난수범위테스트() {
        gameManager newGameManager = new gameManager();
        int[] generatedRandNum = newGameManager.generateRand();

        for (int num : generatedRandNum) {
            assertTrue(num >= 1 && num <= 9);
        }
    }


}
