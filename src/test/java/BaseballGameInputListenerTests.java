import camp.nextstep.edu.application.core.NumberBaseballGame;
import camp.nextstep.edu.application.core.NumberBaseballGameConfig;
import camp.nextstep.edu.global.InputListener;
import camp.nextstep.edu.global.InputSubmitFlag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class BaseballGameInputListenerTests {

    private NumberBaseballGameConfig config;
    private NumberBaseballGame game;
    private InputListener inputListener;

    @BeforeEach
    void setUp() {
        config = new NumberBaseballGameConfig();
        game = config.createNumberBaseballGame();
        inputListener = config.createInputListener(game);
    }

    @Test
    @DisplayName("입력값 리스너 준비 테스트")
    void listenerReadyTest() {
        game.run();

        assertThat(inputListener.ready()).isTrue();
    }

    @Test
    @DisplayName("게임 종료 시 입력값 리스너 준비 테스트")
    void listenerReadyTestWhenGameStop() {
        game.run();
        game.stop();

        assertThat(inputListener.ready()).isFalse();
    }

    @Test
    @DisplayName("입력값 제출 테스트")
    void inputSubmitTest() {
        String input = "123";
        game.run();

        assertThat(inputListener.onInputSubmitted(input)).isEqualTo(InputSubmitFlag.CONTINUE);
    }

    @Test
    @DisplayName("게임 종료 시 입력값 제출 테스트")
    void inputSubmitTestWhenGameStop() {
        String input = "123";
        game.run();
        game.stop();

        assertThat(inputListener.onInputSubmitted(input)).isEqualTo(InputSubmitFlag.CLOSE_SUBMITTING_INPUT);
    }
}
