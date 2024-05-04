package com.mini.numbaseball.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    @DisplayName("사용자 답 입력값 유효성 검사")
    void validateInputTest() {
        GameController gameController = new GameController();

        assertThat(123).isEqualTo(gameController.validateInput("123"));

        assertThatThrownBy(() -> gameController.validateInput("1234"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 세 자리가 아닙니다.");

        assertThatThrownBy(() -> gameController.validateInput("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 정수가 아닙니다.");

        assertThatThrownBy(() -> gameController.validateInput("111"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값에 중복된 숫자가 있습니다.");

        assertThatThrownBy(() -> gameController.validateInput("012"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값에 1부터 9까지의 숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("재시작 여부 입력값 유효성 검사")
    void validateIsReplayTest(){
        GameController gameController = new GameController();

        assertThat(true).isEqualTo(gameController.validateIsReplay("1"));

        assertThat(false).isEqualTo(gameController.validateIsReplay("2"));

        assertThatThrownBy(() -> gameController.validateIsReplay("abc"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 정수가 아닙니다.");

        assertThatThrownBy(() -> gameController.validateIsReplay("3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 1 또는 2가 아닙니다.");
    }
}