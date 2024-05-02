package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 플레이어의_숫자를_제대로_저장할_수_있다() {
        // given
        Player player = Player.create("123");

        // when, then
        Assertions.assertThat(player.getPlayerAnswer()).isEqualTo("123");
    }
}