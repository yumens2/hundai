package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @Test
    @DisplayName("커맨드로 1을 입력한 경우 true를 반환한다.")
    void isRestartingTrue() {
        // given
        final String waitingCommand = "1";

        // when
        final boolean isRestarting = GameCommand.isRestarting(waitingCommand);

        // then
        assertThat(isRestarting).isTrue();
    }

    @Test
    @DisplayName("커맨드로 2을 입력한 경우 false를 반환한다.")
    void isRestartingFalse() {
        // given
        final String waitingCommand = "2";

        // when
        final boolean isRestarting = GameCommand.isRestarting(waitingCommand);

        // then
        assertThat(isRestarting).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "a", "3"})
    @DisplayName("커맨드로 1, 2 이외의 다른 입력이 들어온 경우 예외가 발생한다.")
    void isRestartingThrowsException(final String waitingCommand) {
        // when, then
        assertThatThrownBy(() -> GameCommand.isRestarting(waitingCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 게임 커맨드를 입력해주세요.");
    }
}
