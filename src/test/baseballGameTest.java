import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

class baseballGameTest {
    @Test
    void testPlayGameWithInvalidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("9999\n".getBytes());
        System.setIn(in);

        GameController gameController = new GameController();
        assertThrows(IllegalArgumentException.class, gameController::playGame);
    }
}
