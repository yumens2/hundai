import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.util.List;

public class PlayerTest {
    @Test
    void testValidInput() {
        String data = "123";
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
        Player player = new Player();

        List<Integer> result = player.guess();
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void testInvalidInput() {
        String data = "abc";
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
        Player player = new Player();

        Exception exception = assertThrows(IllegalArgumentException.class, player::guess);
        assertEquals("잘못된 값을 입력하셨습니다.", exception.getMessage());
    }
}
