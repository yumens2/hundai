package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("저장된 값 확인 테스트")
    void setPlayerNumber() {
        String number = "546";
        player.setPlayerNumber(number);
        Assertions.assertThat(player.getPlayerNumber()).isEqualTo(number);
    }
}