import computer.Computer;
import game.BaseBallGameService;
import game.GameCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private final Application application = new Application(
            new Computer(),
            new BaseBallGameService(),
            new GameCondition()
    );

    private final InputStream systemIn = System.in;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(testOut));
    }
    @AfterEach
    public void restoreSystemInput() {
        System.setOut(standardOut);
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("서로다른 1~9 까지의 3자리 수 입력이 아닌 경우")
    void userInvalidInputTest(){
        String invalidInput = "a23";
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(testIn);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, application::start);

        assertThat(illegalArgumentException.getMessage()).isEqualTo("잘못된 입력입니다. 애플리케이션을 종료합니다.");
    }

    @Test
    @DisplayName("게임이 종료되고 1과 2의 입력이 아닌 경우")
    void userInvalidInputTest2(){
        application.getComputer().changeNumber("123");
        String invalidInput = "123\na\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(testIn);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, application::start);

        assertThat(illegalArgumentException.getMessage()).isEqualTo("입력이 1과 2가 아닙니다. 애플리케이션을 종료합니다.");
    }

    @Test
    @DisplayName("게임 정상 흐름 테스트")
    void normalFlowTest(){
        application.getComputer().changeNumber("123");
        String invalidInput = "123\n2\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(testIn);

        application.start();

        assertTrue(testOut.toString().contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료"));
        assertTrue(testOut.toString().contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
        assertTrue(testOut.toString().contains("안녕히 가세요"));
    }

}