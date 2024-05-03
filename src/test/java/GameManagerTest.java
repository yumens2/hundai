import main.GameManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    public void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void testCheckGuess() {
        // Assuming the computer's number is "425"
        String computerNumber = "425";

        assertThat(gameManager.checkGuess(computerNumber, "123")).isEqualTo("1스트라이크");
        assertThat(gameManager.checkGuess(computerNumber, "456")).isEqualTo("1볼 1스트라이크");
        assertThat(gameManager.checkGuess(computerNumber, "789")).isEqualTo("낫싱");
        assertThat(gameManager.checkGuess(computerNumber, "425")).isEqualTo("3스트라이크");
    }
}
