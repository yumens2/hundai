package com.ktc2.precourse.baseball.object;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchResultTest {

    @Test
    void testToString() {
        assertThat(new MatchResult(0, 0).toString())
                .isEqualTo("낫싱");

        for (int strike = 1; strike <= 3; strike++) {
            assertThat(new MatchResult(strike, 0).toString())
                    .isEqualTo(strike + " 스트라이크 ");
        }

        for (int ball = 1; ball <= 3; ball++) {
            assertThat(new MatchResult(0, ball).toString())
                    .isEqualTo(ball + " 볼 ");
        }

        for (int strike = 1; strike <= 3; strike++) {
            for (int ball = 1; ball <= 3; ball++) {
                assertThat(new MatchResult(strike, ball).toString())
                        .isEqualTo(strike + " 스트라이크 " + ball + " 볼 ");
            }
        }
    }
}