import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public void invalidLengthInputTest() {
        gameManager newGameManager = new gameManager();

        String input = "12\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, newGameManager::getInput);
    }

    @Test
    public void nonUniqueDigitsInputTest() {
        gameManager newGameManager = new gameManager();

        String input = "112\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, newGameManager::getInput);
    }

    @Test
    public void invalidDigitsInputTest() {
        gameManager newGameManager = new gameManager();

        String input = "1a3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, newGameManager::getInput);
    }

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3, '3개의 숫자를 모두 맞히셨습니다! 게임 종료'",
        "4, 5, 6, '낫싱'",
        "1, 5, 6, '1스트라이크'",
        "4, 1, 2, '2볼'",
        "1, 3, 5, '1볼 1스트라이크'",
        "1, 2, 5, '2스트라이크'"
    })
    public void computeBallCountTest(int num1, int num2, int num3, String expectedOutput) {
        gameManager newGameManager = new gameManager();
        int[] randNum = {1, 2, 3};
        int[] userNum = {num1, num2, num3};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        newGameManager.computeBallCount(randNum, userNum);

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void gameMenuOption1Test() {
        gameManager newGameManager = new gameManager();
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertTrue(newGameManager.gameMenu());
    }
}
