package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallGameServiceTest {

    private final BaseBallGameService baseBallGameService = new BaseBallGameService();

    @Test
    @DisplayName("스트라이크 개수 체크 Test")
    void checkStrikeTest(){
        String computerNumber = "123";
        String userNumber = "123";

        int strike = baseBallGameService.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(3);

        userNumber = "523";
        strike = baseBallGameService.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(2);

        userNumber = "563";
        strike = baseBallGameService.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(1);

        userNumber = "564";
        strike = baseBallGameService.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 개수 체크 Test")
    void checkBallTest(){
        String computerNumber = "123";
        String userNumber = "123";

        int ball = baseBallGameService.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(0);

        userNumber = "312";
        ball = baseBallGameService.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(3);

        userNumber = "412";
        ball = baseBallGameService.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(2);

        userNumber = "415";
        ball = baseBallGameService.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 스트라이크 낫싱 정보 출력")
    void printInfoTest(){
        assertThat(baseBallGameService.printGameInfo(0, 0)).isEqualTo("낫싱");
        assertThat(baseBallGameService.printGameInfo(2, 0)).isEqualTo("2스트라이크");
        assertThat(baseBallGameService.printGameInfo(2, 0)).isEqualTo("2스트라이크");
        assertThat(baseBallGameService.printGameInfo(1, 2)).isEqualTo(2+"볼 "+1+"스트라이크");
        assertThat(baseBallGameService.printGameInfo(0, 3)).isEqualTo(3+"볼");
    }

    @Test
    @DisplayName("입력 유효성 테스트")
    void inputValidTest(){
        assertThat(baseBallGameService.checkNumberValid("123")).isTrue();
        assertThat(baseBallGameService.checkNumberValid("312")).isTrue();
        assertThat(baseBallGameService.checkNumberValid("agb")).isFalse();
        assertThat(baseBallGameService.checkNumberValid("122")).isFalse();
        assertThat(baseBallGameService.checkNumberValid("12")).isFalse();
        assertThat(baseBallGameService.checkNumberValid("120")).isFalse();
    }


}