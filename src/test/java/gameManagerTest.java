import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class gameManagerTest {

    @Test
    public void randNumLengthTest() {
        gameManager newGameManager = new gameManager();
        int[] generatedRandNum = newGameManager.generateRand();

        assertEquals(generatedRandNum.length, 3);
    }

    @Test
    public void randNumRangeTest() {
        gameManager newGameManager = new gameManager();
        int[] generatedRandNum = newGameManager.generateRand();

        for (int num : generatedRandNum) {
            assertTrue(num >= 1 && num <= 9);
        }
    }

    @Test
    public void validInputTest() {
        gameManager newGameManager = new gameManager();

        String input = "123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int[] expected = {1, 2, 3};
        int[] actual = newGameManager.getInput();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void invalidLengthInputeTest() {
        gameManager newGameManager = new gameManager();

        String input = "12\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> newGameManager.getInput());
    }

}
