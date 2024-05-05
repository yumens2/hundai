import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class CompareTest {

    @Test
    @DisplayName("완전히 일치하는 경우")
    public void testPerfectMatch() {
        assertEquals("3스트라이크", Compare.compareNumbers(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("숫자는 맞지만 위치가 다른 경우")
    public void testAllBalls() {
        assertEquals("3볼", Compare.compareNumbers(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2)));
    }

    @Test
    @DisplayName("숫자와 위치가 일부만 일치하는 경우")
    public void testSomeMatches() {
        assertEquals("1볼 1스트라이크", Compare.compareNumbers(Arrays.asList(2, 4, 5), Arrays.asList(2, 1, 4)));
    }

    @Test
    @DisplayName("전혀 일치하지 않는 경우")
    public void testNoMatch() {
        assertEquals("낫싱", Compare.compareNumbers(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
    }
}
