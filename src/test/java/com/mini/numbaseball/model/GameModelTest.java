package com.mini.numbaseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameModelTest {

    @Test
    @DisplayName("Answer 값 생성 검사")
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

    @ParameterizedTest
    @DisplayName("Strike 개수 카운팅 검사")
    @CsvSource({
        "123, 456, 0",
        "123, 145, 1",
        "123, 523, 2",
        "987, 987, 3"
    })
    void countStrikeTest(int guess, int answer, int expectedStrike) {
        GameModel gameModel = new GameModel();
        int actualStrike = gameModel.countStrike(guess, answer);
        assertThat(actualStrike).isEqualTo(expectedStrike);
    }

    @ParameterizedTest
    @DisplayName("Ball 개수 카운팅 검사")
    @CsvSource({
        "123, 456, 0",
        "123, 123, 0",
        "789, 475, 1",
        "123, 321, 2",
        "123, 231, 3"
    })
    void countBallTest(int guess, int answer, int expectedBall){
        GameModel gameModel = new GameModel();
        int actualBall = gameModel.countBall(guess, answer);
        assertThat(actualBall).isEqualTo(expectedBall);
    }
}