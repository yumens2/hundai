package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    private final BaseBallGame baseBallGame = new BaseBallGame();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("스트라이크 개수 체크 Test")
    void checkStrikeTest(){
        String computerNumber = "123";
        String userNumber = "123";

        int strike = baseBallGame.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(3);

        userNumber = "523";
        strike = baseBallGame.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(2);

        userNumber = "563";
        strike = baseBallGame.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(1);

        userNumber = "564";
        strike = baseBallGame.checkStrike(computerNumber, userNumber);
        assertThat(strike).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 개수 체크 Test")
    void checkBallTest(){
        String computerNumber = "123";
        String userNumber = "123";

        int ball = baseBallGame.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(0);

        userNumber = "312";
        ball = baseBallGame.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(3);

        userNumber = "412";
        ball = baseBallGame.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(2);

        userNumber = "415";
        ball = baseBallGame.checkBall(computerNumber, userNumber);
        assertThat(ball).isEqualTo(1);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_출력_TEST(){
        baseBallGame.printGameInfo(0, 0);
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void 쓰리_스트라이크_TEST(){
        baseBallGame.printGameInfo(3, 0);
        assertEquals(3+"스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void 투볼_원스트라이크_TEST(){
        baseBallGame.printGameInfo(1, 2);
        assertEquals(2+"볼 "+1+"스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("3볼 테스트")
    void 쓰리볼_TEST(){
        baseBallGame.printGameInfo(0, 3);
        assertEquals(3+"볼", outputStreamCaptor.toString().trim());
    }

}