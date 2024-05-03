package com.mini.numbaseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameModelTest {

    @Test
    void initAnswerTest() {
        GameModel gameModel = new GameModel();
        gameModel.initAnswer();

        int answer = gameModel.getAnswer();

        // 값 초기화 테스트
        assertThat(answer).isNotEqualTo(0);

        // 세 자리수 테스트
        assertThat(Integer.toString(answer)).matches("[1-9]{3}");

        // 자리수 중복 테스트
        int first = answer / 100;
        int second = (answer / 10) % 10;
        int third = answer % 10;
        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(first).isNotEqualTo(third);
    }

    @Test
    void countStrikeTest() {
        GameModel gameModel = new GameModel();

        // 0-3 strike 개수 카운팅 테스트
        assertThat(gameModel.countStrike(123, 456)).isEqualTo(0);
        assertThat(gameModel.countStrike(123, 145)).isEqualTo(1);
        assertThat(gameModel.countStrike(123, 523)).isEqualTo(2);
        assertThat(gameModel.countStrike(987, 987)).isEqualTo(3);
    }
}