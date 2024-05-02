import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballUtilTest {
    private BaseballUtil baseballUtil = new BaseballUtil();

    @Test
    public void 스트라이크_같은_수() {
        String random = "156";
        String input = "156";
        assertEquals(3, baseballUtil.strike(random, input));
    }

    @Test
    public void 한_자리_수_스트라이크_같은_수() {
        String random = "456";
        String input = "496";
        assertEquals(2, baseballUtil.strike(random, input));
    }

    @Test
    public void 모두_다른_수() {
        String random = "897";
        String input = "123";
        assertEquals(0, baseballUtil.strike(random, input));
    }

    @Test
    public void 볼_같은_수() {
        String random = "123";
        String input = "123";
        assertEquals(0, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_모든_자리_다름() {
        String random = "894";
        String input = "123";
        assertEquals(0, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_다른_자리_세_개() {
        String random = "145";
        String input = "451";
        assertEquals(3, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_다른_자리_두_개() {
        String random = "145";
        String input = "471";
        assertEquals(2, baseballUtil.ball(random, input));
    }
}