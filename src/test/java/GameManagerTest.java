import domain.Computer;
import domain.ComputerImpl;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;


public class GameManagerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {

        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void setDown() {
        System.setOut(standardOut);
    }

    @Test
    public void battingTest(){
        // given
        GameManager manager = new GameManager();
        Computer computer = new ComputerImpl();
        String testUserInput = "123";
        System.setIn(new ByteArrayInputStream(testUserInput.getBytes()));

        // when
        List<Integer> randomBalls = List.of(1, 2, 3);
        manager.batting(computer, randomBalls);

        // then
        String[] outputs = outputStreamCaptor.toString().split(System.lineSeparator());


        assertThat(outputs[0]).isEqualTo("숫자를 입력해 주세요 : ");
        assertThat(outputs[1]).isEqualTo("3스트라이크");
        assertThat(outputs[2]).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    @Test
    public void battingTest2() {
    }
}