import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class inputTest {

    @Test
    @DisplayName("input test")
    public void inputTesting() {
        String input = "123";
        play playing = new play();
        List<Integer> inputNum = playing.checkInput(input);

        for (int i = 0; i < inputNum.size(); i++) {
            assertTrue(inputNum.get(i) instanceof Integer);
        }
    }

}
