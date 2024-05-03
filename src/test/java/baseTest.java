import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    void testGenerateComputerNumbers() {
        int[] computerNumbers = Main.generateComputerNumbers();
        assertNotNull(computerNumbers);
        assertEquals(Main.DIGIT_COUNT, computerNumbers.length);
        for (int number : computerNumbers) {
            assertTrue(number >= Main.MIN_NUMBER && number <= Main.MAX_NUMBER);
        }
    }

    @Test
    void testGetUserNumbers_ValidInput() {
        provideInput("123");
        int[] userNumbers = Main.getUserNumbers(new Scanner(System.in));
        assertArrayEquals(new int[]{1, 2, 3}, userNumbers);
    }

    @Test
    void testGetUserNumbers_InvalidInput_Length() {
        provideInput("12");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.getUserNumbers(new Scanner(System.in));
        });
        assertEquals("숫자의 길이가 올바르지 않습니다.", exception.getMessage());
    }

    @Test
    void testCheckMatch_AllStrike() {
        int[] computerNumbers = {1, 2, 3};
        int[] userNumbers = {1, 2, 3};
        assertTrue(Main.checkMatch(computerNumbers, userNumbers));
    }

    private void provideInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }
}
