import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ComputerTests {
    Computer com;

    @BeforeEach
    void createComputerInstance() {
        com = new Computer();
    }

    @DisplayName("유저 입력 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "111", "122", "aaa", "1234", "abcd", "ab345"})
    void inputValidationCheckTest(String nums) {
        assertThatThrownBy(() -> {
            com.inputValidationCheck(nums);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(20)
    @DisplayName("랜덤 숫자 생성 및 유효성 테스트")
    void generateRandNumTest() {
        com.generateRandNum();
        com.inputValidationCheck(com.getRandNum());
    }

    @Test
    @DisplayName("Strike/ball 점수 계산 테스트")
    void calcScoreTest() {
        com.generateRandNum();
        String randNum = com.getRandNum();

        // 3 strike
        com.calcScore(randNum);
        assertThat(com.getStrikeScore()).isEqualTo(3);
        assertThat(com.getBallScore()).isEqualTo(0);

        // nothing
        com.calcScore("abc");
        assertThat(com.getStrikeScore()).isEqualTo(0);
        assertThat(com.getBallScore()).isEqualTo(0);

         // 2 strike, 0 ball
        com.calcScore(randNum.charAt(0) + "b" + randNum.charAt(2));
        assertThat(com.getStrikeScore()).isEqualTo(2);
        assertThat(com.getBallScore()).isEqualTo(0);

        // 1 strike, 0 ball
        com.calcScore(randNum.charAt(0) + "b" + "c");
        assertThat(com.getStrikeScore()).isEqualTo(1);
        assertThat(com.getBallScore()).isEqualTo(0);


        // 0 strike, 2 ball
        com.calcScore(randNum.charAt(2) + "b" + randNum.charAt(0));
        assertThat(com.getStrikeScore()).isEqualTo(0);
        assertThat(com.getBallScore()).isEqualTo(2);
    }

    @Test
    @DisplayName("3 Strike 게임 종료 테스트")
    void isGameFinishTest() {
        com.generateRandNum();
        com.calcScore(com.getRandNum());    // 3스트라이크인 입력
        assertThat(com.isGameFinish()).isEqualTo(true);
    }

    @Test
    @DisplayName("계산된 strike/ball 출력 테스트")
    void printScoreTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        com.generateRandNum();
        String randNum = com.getRandNum();

        com.calcScore(randNum);
        com.printScore();
        assertThat(out.toString()).isEqualTo("3스트라이크 \n");

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        com.calcScore("abc");
        com.printScore();
        assertThat(out.toString()).isEqualTo("낫싱\n");

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        com.calcScore(randNum.charAt(0) + "b" + randNum.charAt(2));
        com.printScore();
        assertThat(out.toString()).isEqualTo("2스트라이크 \n");

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        com.calcScore(randNum.charAt(0) + "b" + "c");
        com.printScore();
        assertThat(out.toString()).isEqualTo("1스트라이크 \n");

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        com.calcScore(randNum.charAt(2) + "b" + randNum.charAt(0));
        com.printScore();
        assertThat(out.toString()).isEqualTo("2볼 \n");
    }

    @Test
    @DisplayName("유저 입력 안내 메시지 테스트")
    void printInputMessageTest() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        com.printInputMessage();
        assertThat(out.toString()).isEqualTo("숫자를 입력해 주세요 : ");
    }
}
