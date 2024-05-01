import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.computerNumbers = Arrays.asList(1, 2, 3);
    }

    @AfterEach
    void tearDown() {
        game = null;
    }

    /**
     * 사용자의 입력이 정확히 처리되는지 확인
     */
    @Test
    void testPlayerInputProcessing() {
        // Arrange
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        String playerInput = game.getPlayerInput();

        // Assert
        assertEquals(input, playerInput);
    }

    /**
     * 재시작이 되는지 확인
     */
    @Test
    void testGameRestart() {
        // Given
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        boolean restart = game.askForRestart();

        // Then
        assertTrue(restart);
    }

    /**
     * 게임종료가 잘 되는지 확인
     */
    @Test
    void testGameEnd() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean end = game.askForRestart();

        assertFalse(end);
    }
}
