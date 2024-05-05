package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallCountTest {

    @ParameterizedTest(name = "{0}볼 {1}스트라이크는 {2}입니다")
    @CsvSource(value = {
        "0,0,낫싱", "0,1,1스트라이크", "0,2,2스트라이크",
        "1,0,1볼", "1,1,1볼 1스트라이크", "1,2,1볼 2스트라이크",
        "2,0,2볼", "2,1,2볼 1스트라이크",
        "3,0,3볼", "0,3,3스트라이크"})
    void 올바르게_스트라이크_볼을_판단하고_결과를_출력합니다(int ball, int strike, String result) {
        BallCount ballCount = new BallCount(strike, ball);
        assertThat(ballCount.getResultMessage().trim()).isEqualTo(result);
    }

}