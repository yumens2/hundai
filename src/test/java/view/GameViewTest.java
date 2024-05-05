package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameViewTest {

    @Test
    @DisplayName("getUserInput test")
    void getUserInputTest() throws Exception {
        //given
        String expectedInput = "123";
        InputStream testInput = new ByteArrayInputStream(expectedInput.getBytes());
        GameView gameView = new GameView(testInput);

        //when
        String actualInput = gameView.getUserInput();

        //then
        assertEquals(expectedInput, actualInput);
    }
}