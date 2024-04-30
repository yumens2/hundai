package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {

    Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    @DisplayName("스트라이크가 증가한다.")
    void increaseStrike() {
        // when
        hint.increaseStrike();

        // then
        assertThat(hint.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("볼이 증가한다.")
    void increaseBall() {
        // when
        hint.increaseBall();

        // then
        assertThat(hint.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크가 3회인 힌트라면 스트라이크 아웃이다.")
    void isStrikeOut() {
        // given
        for (int i = 0; i < 3; i++) {
            hint.increaseStrike();
        }

        // when
        final boolean isStrikeOut = hint.isStrikeOut();

        // then
        assertThat(isStrikeOut).isTrue();
    }

    @Test
    @DisplayName("스트라이크가 3회가 아닌 힌트면 스트라이크 아웃이 아니다.")
    void isNotStrikeOut() {
        // given
        for (int i = 0; i < 2; i++) {
            hint.increaseStrike();
        }

        // when
        final boolean isStrikeOut = hint.isStrikeOut();

        // then
        assertThat(isStrikeOut).isFalse();
    }

    @Test
    @DisplayName("스트라이크가 초기 개수가 아니라면 true를 반환한다.")
    void hasStrike() {
        // given
        hint.increaseStrike();

        // when
        final boolean isNotInitialStrikeCount = hint.hasStrike();

        // then
        assertThat(isNotInitialStrikeCount).isTrue();
    }

    @Test
    @DisplayName("볼이 초기 개수가 아니라면 true를 반환한다.")
    void hasBall() {
        // given
        hint.increaseBall();

        // when
        final boolean isNotInitialBallCount = hint.hasBall();

        // then
        assertThat(isNotInitialBallCount).isTrue();
    }

    @Test
    @DisplayName("스트라이크와 볼의 개수가 초기 개수와 같다면 true를 반환한다.")
    void isNothing() {
        // when
        final boolean isNothing = hint.isNothing();

        // then
        assertThat(isNothing).isTrue();
    }
}
