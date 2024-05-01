import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class RefereeTest {

    @Test
    public void testDetermineResultAllStrikes() {
        Referee referee = new Referee();
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);

        // 모든 숫자가 일치하므로 스트라이크 3, 볼 0이 되어야 함
        int[] result = referee.determineResult(computerNumbers, playerNumbers);
        assertEquals(3, result[0]); // 스트라이크 개수 확인
        assertEquals(0, result[1]); // 볼 개수 확인
    }

    @Test
    public void testDetermineResultAllBalls() {
        Referee referee = new Referee();
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(2, 3, 1);

        // 모든 숫자가 존재하고 위치가 다르므로 볼 3, 스트라이크 0이 되어야 함
        int[] result = referee.determineResult(computerNumbers, playerNumbers);
        assertEquals(0, result[0]); // 스트라이크 개수 확인
        assertEquals(3, result[1]); // 볼 개수 확인
    }

    @Test
    public void testDetermineResultMixed() {
        Referee referee = new Referee();
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 3, 5);

        // 일치하는 숫자가 하나 있고 위치도 일치하므로 스트라이크 1, 볼 1이 되어야 함
        int[] result = referee.determineResult(computerNumbers, playerNumbers);
        assertEquals(1, result[0]); // 스트라이크 개수 확인
        assertEquals(1, result[1]); // 볼 개수 확인
    }
}
