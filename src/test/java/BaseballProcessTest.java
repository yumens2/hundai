import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class BaseballProcessTest {

    private BaseballProcess baseballProcess;

    @BeforeEach
    void setUp() {
        baseballProcess = new BaseballProcess();
        baseballProcess.setRandomNumber(Arrays.asList(1, 2, 3));
    }

    @Test
    void testParseInput() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(baseballProcess.parseInput("123")).isEqualTo(expected);
    }

    @Test
    void testCheckGuess() {
        assertThat(baseballProcess.checkGuess(Arrays.asList(1, 2, 3))).containsExactly(3, 0);
        assertThat(baseballProcess.checkGuess(Arrays.asList(1, 2, 4))).containsExactly(2, 0);
        assertThat(baseballProcess.checkGuess(Arrays.asList(4, 1, 2))).containsExactly(0, 2);
    }
}
