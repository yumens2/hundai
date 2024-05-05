import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HintTest {

    @Test
    public void testHint() {
        // Given
        int computerNumber = 123;

        // When
        String hint1 = Hint.hint(computerNumber, 123); // 3 스트라이크
        String hint2 = Hint.hint(computerNumber, 456); // 낫싱
        String hint3 = Hint.hint(computerNumber, 312); // 3볼
        String hint4 = Hint.hint(computerNumber, 231); // 3볼
        String hint5 = Hint.hint(computerNumber, 135); // 1 스트라이크 1 볼

        // Then
        assertEquals("3스트라이크", hint1);
        assertEquals("낫싱", hint2);
        assertEquals("3볼", hint3);
        assertEquals("3볼", hint4);
        assertEquals("1스트라이크1볼", hint5);
    }
}
