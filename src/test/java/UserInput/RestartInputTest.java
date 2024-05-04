package UserInput;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartInputTest {

    @DisplayName("Restart Input Success Test")
    @Test
    void restartInput() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        int restartGame = RestartInput.restartInput();
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        int stop = RestartInput.restartInput();
        assertAll("Restart Input Success Test",
            () -> assertEquals(1, restartGame),
            () -> assertEquals(2, stop)
        );
    }

    @DisplayName("Restart Input Fail Test")
    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "4", "5", "aaaa", "@@@", "a\naadadas"})
    void restartInputFail(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(IllegalArgumentException.class, RestartInput::restartInput);
    }
}