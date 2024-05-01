import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayerTest {

    @Test
    public void testConvertInputToListValidInput() {
        Player player = new Player();
        String input = "123";
        List<Integer> numbers = player.convertInputToList(input);

        // 유효한 입력이므로 3자리 숫자인지 확인
        assertEquals(3, numbers.size());
        // 각 자리수가 정확히 변환되었는지 확인
        assertEquals(1, numbers.get(0));
        assertEquals(2, numbers.get(1));
        assertEquals(3, numbers.get(2));
    }

    @Test
    public void testConvertInputToListInvalidInput() {
        Player player = new Player();
        String input = "12a";

        // 유효하지 않은 입력이므로 IllegalArgumentException이 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> {
            player.convertInputToList(input);
        });
    }

}
