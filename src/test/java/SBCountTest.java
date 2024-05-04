import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class SBCountTest {
    @DisplayName("toStringTest")
    @ParameterizedTest(name = "스트라이크가 {0}개, 볼이 {1}개일 때")
    @CsvSource({
            "1, 2, '2볼', '1스트라이크'",
            "0, 1, '1볼', ''",
            "3, 0, '', '3스트라이크'"
    })
    public void testToString(int strike, int ball, String begin, String end) {

        Assertions.assertThat(new SBCount(strike, ball).toString())
                .startsWith(begin)
                .endsWith(end);
    }
}
