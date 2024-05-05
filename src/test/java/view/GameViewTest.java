package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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

    @Test
    @DisplayName("displayResult test")
    void displayResultTest() throws Exception {
        //given
        String input1 = "1볼 1스트라이크";
        String input2 = "낫싱";
        String input3 = "3스트라이크";

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        GameView gameView = new GameView(System.in);

        //when
        gameView.displayResult(input1);
        gameView.displayResult(input2);
        gameView.displayResult(input3);

        //then
        String expectedOutput = input1 + "\n" + input2 + "\n" + input3 + "\n";
        assertEquals(expectedOutput, outputContent.toString());

    }
}