import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.ByteArrayInputStream;

public class RestartTest {
    @Test
    void testAskForRestartYes() {
        String data = "1";
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);

        Restart restart = new Restart();
        assertTrue(restart.askForRestart(), "게임을 새로 시작해야 합니다.");
    }

    @Test
    void testAskForRestartNo() {
        String data = "2";
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);

        Restart restart = new Restart();
        assertFalse(restart.askForRestart(), "게임을 종료해야 합니다.");
    }
}