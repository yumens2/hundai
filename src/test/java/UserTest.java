import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    @DisplayName("입력한값이 제대로 입력이 되는지 확인")
    public void testValidInput() {
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes()); //Scanner Test
        System.setIn(in);
        List<Integer> result = User.createInputNum();

        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }
    @Test
    @DisplayName("중복되는 숫자 확인")
    public void testInvalidInput_SameDigits() {
        String input = "112\n";
        InputStream in = new ByteArrayInputStream(input.getBytes()); //Scanner Test
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> {
            User.createInputNum();
        });
    }

    @Test
    @DisplayName("숫자 외에 다른 문자가 포함되어있는지 확인")
    public void testInvalidInput_isContainNotDigit() {
        String input = "1a3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes()); //Scanner Test
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, () -> {
            User.createInputNum();
        });
    }

}
