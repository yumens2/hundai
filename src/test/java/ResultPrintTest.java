import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultPrintTest {
    @DisplayName("출력 값 검증 : 낫싱 출력")
    @Test
    void judge_ReturnsNothins() {
        // given
        ResultPrint resultPrint = new ResultPrint();

        // when
        String result = resultPrint.judge(0, 0);

        // then
        assertEquals("낫싱", result);
    }

    @DisplayName("출력 값 검증 : 스트라이크")
    @Test
    void judge_ReturnsStrike() {
        // given
        ResultPrint resultPrint = new ResultPrint();

        // when
        String result = resultPrint.judge(2, 2);

        // then
        assertEquals("2스트라이크", result);
    }

    @DisplayName("출력 값 검증 : 볼")
    @Test
    void judge_ReturnsBalls() {
        // given
        ResultPrint resultPrint = new ResultPrint();

        // when
        String result = resultPrint.judge(2, 0);

        // then
        assertEquals("2볼", result);
    }

    @DisplayName("출력 값 검증 : 볼 & 스트라이크")
    @Test
    void judge_ReturnsBallsAndStrike() {
        // given
        ResultPrint resultPrint = new ResultPrint();

        // when
        String result = resultPrint.judge(3, 2);

        // then
        assertEquals("1볼 2스트라이크", result);
    }
}