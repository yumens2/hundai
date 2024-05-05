import camp.nextstep.edu.application.core.NumberBaseballGame;
import camp.nextstep.edu.application.core.NumberBaseballGameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberBaseballGameTests {

    private static final NumberBaseballGameConfig config = new NumberBaseballGameConfig();
    private NumberBaseballGame numberBaseballGame;

    @BeforeEach
    void setUp() {
        numberBaseballGame = config.createNumberBaseballGame();
    }

    @Test
    @DisplayName("숫자 야구 게임 시작 테스트")
    void startGameTest() {
        numberBaseballGame.run();

        assertThat(numberBaseballGame.isRunning()).isTrue();
        assertThatThrownBy(() -> numberBaseballGame.run()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("숫자 야구 게임 종료 테스트")
    void endGameTest() {
        numberBaseballGame.run();
        numberBaseballGame.stop();

        assertThat(numberBaseballGame.isRunning()).isFalse();
        assertThatThrownBy(() -> numberBaseballGame.stop()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("게임을 시작하지 않고 종료할 경우 예외 발생 테스트")
    void endGameWithoutStartGameTest() {
        assertThatThrownBy(() -> numberBaseballGame.stop()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("게임을 시작하지 않고 입력값을 제출할 경우 예외 발생 테스트")
    void submitInputWithoutStartGameTest() {
        assertThatThrownBy(() -> numberBaseballGame.onInputSubmitted("123")).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("입력값을 모두 맞췄을 경우 게임 일시 중지 테스트")
    void submitCorrectInputTest() {
        numberBaseballGame.run();
        numberBaseballGame.success();

        assertThat(numberBaseballGame.isRunning()).isTrue();
        assertThat(numberBaseballGame.isPaused()).isTrue();
    }

    @Test
    @DisplayName("실행 중이 아닌 상태에서 일시 중지할 경우 예외 발생 테스트")
    void pauseGameWithoutStartGameTest() {
        assertThatThrownBy(() -> numberBaseballGame.success()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("일시 중지 상태에서 일시 중지 시 예외 발생 테스트")
    void pauseGameWhilePausedTest() {
        numberBaseballGame.run();
        numberBaseballGame.success();

        assertThatThrownBy(() -> numberBaseballGame.success()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("게임 중지 후 게임 진행 여부 결정 테스트 (종료시키기)")
    void decideAfterPauseGameTest1() {
        numberBaseballGame.run();
        numberBaseballGame.success();
        numberBaseballGame.onInputSubmitted("2");

        assertThat(numberBaseballGame.isRunning()).isFalse();
    }

    @Test
    @DisplayName("게임 중지 후 게임 진행 여부 결정 테스트 (재시작하기)")
    void decideAfterPauseGameTest2() {
        numberBaseballGame.run();
        numberBaseballGame.success();
        numberBaseballGame.onInputSubmitted("1");

        assertThat(numberBaseballGame.isRunning()).isTrue();
    }

    @Test
    @DisplayName("게임 중지 후 게임 진행 여부 결정 테스트 (예외 발생)")
    void decideAfterPauseGameTest3() {
        numberBaseballGame.run();
        numberBaseballGame.success();
        assertThatThrownBy(() -> numberBaseballGame.onInputSubmitted("3")).isInstanceOf(IllegalArgumentException.class);
    }
}
