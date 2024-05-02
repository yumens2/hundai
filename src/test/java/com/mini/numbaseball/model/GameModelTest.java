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

        // 값 초기화 확인
        assertThat(answer).isNotEqualTo(0);

        // 세 자리수 확인
        assertThat(Integer.toString(answer)).matches("[1-9]{3}");

        // 자리수 중복 확인
        int first = answer/100;
        int second = (answer/10)%10;
        int third = answer%10;
        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(first).isNotEqualTo(third);
    }
}