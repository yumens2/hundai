import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @DisplayName("1볼")
    @Test
    public void test1() {
        assertThat(Util.countBall("123", "451")).isEqualTo(1);
        assertThat(Util.countBall("123", "415")).isEqualTo(1);
        assertThat(Util.countBall("123", "452")).isEqualTo(1);
        assertThat(Util.countBall("123", "245")).isEqualTo(1);
        assertThat(Util.countBall("123", "345")).isEqualTo(1);
        assertThat(Util.countBall("123", "435")).isEqualTo(1);
    }

    @DisplayName("2볼")
    @Test
    public void test2() {
        assertThat(Util.countBall("123", "214")).isEqualTo(2);
        assertThat(Util.countBall("123", "412")).isEqualTo(2);
        assertThat(Util.countBall("123", "432")).isEqualTo(2);
        assertThat(Util.countBall("123", "342")).isEqualTo(2);
        assertThat(Util.countBall("123", "431")).isEqualTo(2);
        assertThat(Util.countBall("123", "341")).isEqualTo(2);
    }

    @DisplayName("3볼")
    @Test
    public void test3() {
        assertThat(Util.countBall("123", "312")).isEqualTo(3);
        assertThat(Util.countBall("123", "231")).isEqualTo(3);
    }

    @DisplayName("1스트라이크")
    @Test
    public void test4() {
        assertThat(Util.countBall("123", "145")).isEqualTo(0);
        assertThat(Util.countStrike("123", "145")).isEqualTo(1);
        assertThat(Util.countBall("123", "425")).isEqualTo(0);
        assertThat(Util.countStrike("123", "425")).isEqualTo(1);
        assertThat(Util.countBall("123", "453")).isEqualTo(0);
        assertThat(Util.countStrike("123", "453")).isEqualTo(1);
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    public void test5() {
        assertThat(Util.countBall("123", "134")).isEqualTo(1);
        assertThat(Util.countStrike("123", "134")).isEqualTo(1);
        assertThat(Util.countBall("123", "421")).isEqualTo(1);
        assertThat(Util.countStrike("123", "421")).isEqualTo(1);
        assertThat(Util.countBall("123", "413")).isEqualTo(1);
        assertThat(Util.countStrike("123", "413")).isEqualTo(1);
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    public void test6() {
        assertThat(Util.countBall("123", "132")).isEqualTo(2);
        assertThat(Util.countStrike("123", "132")).isEqualTo(1);
        assertThat(Util.countBall("123", "321")).isEqualTo(2);
        assertThat(Util.countStrike("123", "321")).isEqualTo(1);
        assertThat(Util.countBall("123", "213")).isEqualTo(2);
        assertThat(Util.countStrike("123", "213")).isEqualTo(1);
    }

    @DisplayName("2스트라이크")
    @Test
    public void test7() {
        assertThat(Util.countBall("123", "124")).isEqualTo(0);
        assertThat(Util.countStrike("123", "124")).isEqualTo(2);
        assertThat(Util.countBall("123", "423")).isEqualTo(0);
        assertThat(Util.countStrike("123", "423")).isEqualTo(2);
        assertThat(Util.countBall("123", "143")).isEqualTo(0);
        assertThat(Util.countStrike("123", "143")).isEqualTo(2);
    }

    @DisplayName("3스트라이크")
    @Test
    public void test8() {
        assertThat(Util.countBall("123", "123")).isEqualTo(0);
        assertThat(Util.countStrike("123", "123")).isEqualTo(3);
    }
}
