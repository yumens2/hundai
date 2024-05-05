import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartTheGameTest {
    @DisplayName("게임 재시작")
    @Test
    void regame_ReturnsTrue() {
        // given
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestartTheGame game = new RestartTheGame();

        // when
        boolean result = game.regame();

        // then
        assertTrue(result);
    }

    @DisplayName("게임 종료")
    @Test
    void regame_ReturnsFalse() {
        // given
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestartTheGame game = new RestartTheGame();

        // when
        boolean result = game.regame();

        // then
        assertFalse(result);
    }
}