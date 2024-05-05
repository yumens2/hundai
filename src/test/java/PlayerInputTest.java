import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PlayerInputTest {

    @Test
    void testGetInputFromUser() {

        String simulatedInput = "723";
        provideSimulatedInput(simulatedInput);

        PlayerInput playerInput = new PlayerInput(simulatedInput);
        String input = playerInput.getInputFromUser();

        assertEquals(simulatedInput, input);
    }

    private void provideSimulatedInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
