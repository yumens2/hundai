import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    public void 컴퓨터난수_길이_테스트(){
        Computer computer = new Computer();
        computer.generate();

        assertEquals(computer.getComputerNumbers().size(), 3);
    }

    @Test
    public void 컴퓨터난수_범위_테스트(){
        Computer computer = new Computer();
        computer.generate();

        List<Integer> answer = computer.getComputerNumbers();
        assertTrue(answer.stream().allMatch(number -> number >= 1 && number <= 9));
    }

    @Test
    public void 컴퓨터난수_고유성_테스트(){
        Computer computer = new Computer();
        computer.generate();

        List<Integer> answer = computer.getComputerNumbers();
        assertEquals(3, new HashSet<>(answer).size());
    }
}
