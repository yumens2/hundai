import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseballUtilTest {
    private BaseballUtil baseballUtil = new BaseballUtil();

    @Test
    public void 스트라이크_같은_수() {
        int random = 156;
        int input = 156;
        assertEquals(3, baseballUtil.strike(random, input));
    }

    @Test
    public void 한_자리_수_스트라이크_같은_수() {
        int random = 456;
        int input = 496;
        assertEquals(2, baseballUtil.strike(random, input));
    }

    @Test
    public void 모두_다른_수() {
        int random = 897;
        int input = 123;
        assertEquals(0, baseballUtil.strike(random, input));
    }

    @Test
    public void 볼_같은_수() {
        int random = 123;
        int input = 123;
        assertEquals(0, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_모든_자리_다름() {
        int random = 894;
        int input = 123;
        assertEquals(0, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_다른_자리_세_개() {
        int random = 145;
        int input = 451;
        assertEquals(3, baseballUtil.ball(random, input));
    }

    @Test
    public void 볼_다른_자리_두_개() {
        int random = 145;
        int input = 471;
        assertEquals(2, baseballUtil.ball(random, input));
    }
}