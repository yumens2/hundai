package baseball;

import baseball.view.GameMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testPrintScoreMessage() {
        GameMessage gameMessage = new GameMessage();
        gameMessage.printScoreMessage(0, 0);
        assertTrue(outputStreamCaptor.toString().trim().equals("낫싱"));

        outputStreamCaptor.reset(); // 스트림 초기화

        gameMessage.printScoreMessage(1, 2);
        assertTrue(outputStreamCaptor.toString().trim().equals("1볼 2스트라이크"));
    }

    @Test
    public void testPrintGameOverMessage() {
        GameMessage.printGameOverMessage();
        assertTrue(outputStreamCaptor.toString().trim().equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료"));
    }

    // RequestInput에 대한 테스트는 복잡성으로 인해 여기서 다루지 않습니다.
    // 일반적으로 표준 입력을 직접 다루는 것은 테스트에서 권장되지 않습니다.
}
