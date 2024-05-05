package view;

import model.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    private static final String MESSAGE_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String HINT_STRIKE = "스트라이크";
    private static final String HINT_BALL = "볼 ";
    private static final String HINT_NOTHING = "낫싱";
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private OutputView outputView;
    private Hint hint;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
        outputView = new OutputView();
        hint = new Hint();
    }

    @Test
    @DisplayName("출력 결과 확인 - 게임 종료")
    void testPrintResult_GameFinish() {
        // given
        // strike 값이 DIGIT 과 같아야 맞춘 것 -> 게임 종료
        hint.increaseStrike();
        hint.increaseStrike();
        hint.increaseStrike();

        // when
        outputView.printResult(hint);

        // then
        assertThat(output.toString().trim()).isEqualTo(MESSAGE_FINISH);
    }

    @Test
    @DisplayName("출력 결과 확인 - 스트라이크")
    void testPrintResult_Strike() {
        // given
        hint.increaseStrike();

        // when
        outputView.printResult(hint);

        // then
        assertThat(output.toString().trim()).isEqualTo(1+HINT_STRIKE);
    }

    @Test
    @DisplayName("출력 결과 확인 - 볼")
    void testPrintResult_Ball() {
        // given
        hint.increaseBall();

        // when
        outputView.printResult(hint);

        // then
        assertThat(output.toString().trim()+" ").isEqualTo(1+HINT_BALL);
    }

    @Test
    @DisplayName("출력 결과 확인 - 볼 스트라이크")
    void testPrintResult_BallStrike() {
        // given
        hint.increaseBall();
        hint.increaseStrike();

        // when
        outputView.printResult(hint);

        // then
        assertThat(output.toString().trim()).isEqualTo(1 +HINT_BALL + 1+ HINT_STRIKE);
    }

    @Test
    @DisplayName("출력 결과 확인 - 낫싱")
    void testPrintResult_Nothing() {
        // given
        // (nothing to increase)

        // when
        outputView.printResult(hint);

        // then
        assertThat(output.toString().trim()).isEqualTo(HINT_NOTHING);
    }
}