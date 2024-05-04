package com.mini.numbaseball.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameViewTest {

    @Test
    @DisplayName("유저 입력 작동 검사")
    void getUserInputTest() {
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        GameView gameView = new GameView();

        int result = gameView.getUserInput();

        assertThat(123).isEqualTo(result);
    }
}