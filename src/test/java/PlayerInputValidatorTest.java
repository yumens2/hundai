import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerInputValidatorTest {

    @Test
    void testValidateInputWithValidInput1() {
        String simulatedInput = "1";
        provideSimulatedInput(simulatedInput);

        boolean result = PlayerInputValidator.validateInput();

        assertTrue(result);
    }

    @Test
    void testValidateInputWithValidInput2() {
        String simulatedInput = "2";
        provideSimulatedInput(simulatedInput);

        boolean result = PlayerInputValidator.validateInput();

        assertFalse(result);
    }

    @Test
    void testValidateInputWithInvalidInput() {
        String simulatedInput = "invalid";
        provideSimulatedInput(simulatedInput);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> PlayerInputValidator.validateInput());
        assertEquals("잘못된 입력입니다.", exception.getMessage());
    }

    @Test
    void testValidateInputWithNoInput() {
        String simulatedInput = "";
        provideSimulatedInput(simulatedInput);

        assertThrows(NoSuchElementException.class, () -> PlayerInputValidator.validateInput());
    }

    private void provideSimulatedInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}
