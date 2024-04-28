import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private Application app;

    @BeforeEach
    public void setUp() {
        app = new Application();
    }

    @Test
    public void testParseInputValid() {
        assertDoesNotThrow(() -> {
            int[] result = app.parseInput("123");
            assertArrayEquals(new int[]{1, 2, 3}, result);
        });
    }

    @Test
    public void testParseInputExceptionForNonDigits() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.parseInput("12a");
        });
        assertTrue(thrown.getMessage().contains("1부터 9까지의 서로 다른 수를 입력해야 합니다."));
    }

    @Test
    public void testParseInputExceptionForDuplicates() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.parseInput("112");
        });
        assertTrue(thrown.getMessage().contains("중복된 숫자가 있습니다."));
    }
}
