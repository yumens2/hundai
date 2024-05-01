import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ComputerTest {

    @Test
    public void testGenerateAnswer() {
        Computer computer = new Computer();
        List<Integer> answer = computer.generateAnswer();

        // 답이 3자리인지 확인
        assertEquals(3, answer.size());

        // 모든 숫자가 1부터 9까지 서로 다른지 확인
        assertTrue(answer.get(0) >= 1 && answer.get(0) <= 9);
        assertTrue(answer.get(1) >= 1 && answer.get(1) <= 9);
        assertTrue(answer.get(2) >= 1 && answer.get(2) <= 9);
        assertNotEquals(answer.get(0), answer.get(1));
        assertNotEquals(answer.get(0), answer.get(2));
        assertNotEquals(answer.get(1), answer.get(2));
    }
}
