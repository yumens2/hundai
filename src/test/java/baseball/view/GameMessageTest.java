package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMessageTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintScoreMessageNothing() {
        GameMessage gameMessage = new GameMessage();
        gameMessage.printScoreMessage(0, 0);
        assertEquals("낫싱\n", outContent.toString());
    }

    @Test
    public void testPrintScoreMessageOnlyStrikes() {
        GameMessage gameMessage = new GameMessage();
        gameMessage.printScoreMessage(0, 3);
        assertEquals("3스트라이크\n", outContent.toString());
    }

    @Test
    public void testPrintScoreMessageOnlyBalls() {
        GameMessage gameMessage = new GameMessage();
        gameMessage.printScoreMessage(2, 0);
        assertEquals("2볼\n", outContent.toString());
    }

    @Test
    public void testPrintScoreMessageBallsAndStrikes() {
        GameMessage gameMessage = new GameMessage();
        gameMessage.printScoreMessage(1, 2);
        assertEquals("1볼 2스트라이크\n", outContent.toString());
    }

    @Test
    public void testPrintGameOverMessage() {
        GameMessage.printGameOverMessage();
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", outContent.toString());
    }
}
