package domain.service;

import static org.junit.jupiter.api.Assertions.*;

import domain.Player;
import domain.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseBallServiceTest {

    @Test
    void 숫자를_가지고_있는_플레이어가_startOneGame함수의_결과로_올바른_Score_를_가져오는지() {
        // given
        Player player = Player.create("123");

        // when
        BaseBallService baseBallService = new BaseBallService("214");
        Score score = baseBallService.startOneGame(player);

        // then
        Assertions.assertThat(score.getStrke().getCount()).isEqualTo(0);
        Assertions.assertThat(score.getBall().getCount()).isEqualTo(2);
    }

    @Test
    void 숫자를_가지고_있는_플레이어가_startOneGame함수의_결과로_올바른_Score_를_가져오는지_2() {
        // given
        Player player = Player.create("123");

        // when
        BaseBallService baseBallService = new BaseBallService("124");
        Score score = baseBallService.startOneGame(player);

        // then
        Assertions.assertThat(score.getStrke().getCount()).isEqualTo(2);
        Assertions.assertThat(score.getBall().getCount()).isEqualTo(0);
    }

    @Test
    void 만약_모든_숫자가_일치한다면_checkGameEnd함수가_true_를_반환하는_지() {
        // given
        Player player = Player.create("123");

        // when
        BaseBallService baseBallService = new BaseBallService("123");

        // then
        Assertions.assertThat(baseBallService.checkGameEnd(player)).isTrue();
    }
}