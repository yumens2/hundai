import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;

    private void provideInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        // 이 메소드는 각 테스트가 끝난 후에 호출됩니다.
    }

    @Test
    void testInputNumbersWithValidInput() {
        String input = "1 2 3\n";
        provideInput(input);

        Player player = new Player();
        player.inputNumbers();
        List<Integer> playerNumbers = player.getPlayerNumbers();
        assertEquals(List.of(1, 2, 3), playerNumbers);
    }

    @Test
    void testInputNumbersWithInvalidNumberOfInputs() {
        String input = "1 2\n";
        provideInput(input);
        Player player = new Player();

        Exception exception = assertThrows(IllegalArgumentException.class, player::inputNumbers);
        assertEquals("입력은 정확히 세 개 여야 합니다.", exception.getMessage());
    }

    @Test
    void testInputNumbersWithNonNumericInput() {
        String input = "1 a 3\n";
        provideInput(input);
        Player player = new Player();

        Exception exception = assertThrows(IllegalArgumentException.class, player::inputNumbers);
        assertEquals("입력은 숫자만 포함해야 합니다", exception.getMessage());
    }
}
