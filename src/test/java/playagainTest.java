import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class playagainTest {

    private final InputStream systemIn = System.in;
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(systemIn);
    }

    @Test
    public void whenInputIs1_thenPlayAgainReturnsTrue() {
        // "1" 입력을 시뮬레이션
        provideInput("1");
        Playagain playagain = new Playagain();

        assertTrue(playagain.playagain(), "1을 입력했을 때 true를 반환해야 합니다.");
    }

}
