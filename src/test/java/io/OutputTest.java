package io;

import static org.assertj.core.api.Assertions.*;

import controller.BaseBallGame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    private final ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restore() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("스트라이크 & 볼")
    void printResult_case1() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        Output output = new Output();

        // when, ballStrike()와 hint를 public으로 설정 후 테스트
//        baseBallGame.ballStrike(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 4));
//        output.printResult(baseBallGame.hint.getBallCount(), baseBallGame.hint.getStrikeCount());

        // then
        assertThat(outputMessage.toString()).isEqualToIgnoringNewLines("1볼 1스트라이크");
    }

    @Test
    @DisplayName("낫싱")
    void printResult_case2() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        Output output = new Output();

        // when, ballStrike()와 hint를 public으로 설정 후 테스트
//        baseBallGame.ballStrike(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
//        output.printResult(baseBallGame.hint.getBallCount(), baseBallGame.hint.getStrikeCount());

        // then
        assertThat(outputMessage.toString()).isEqualToIgnoringNewLines("낫싱");
    }

    @Test
    @DisplayName("스트라이크 아웃")
    void printResult_case3() {
        // given
        BaseBallGame baseBallGame = new BaseBallGame();
        Output output = new Output();

        // when, ballStrike()와 hint를 public으로 설정 후 테스트
//        baseBallGame.ballStrike(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
//        output.printResult(baseBallGame.hint.getBallCount(), baseBallGame.hint.getStrikeCount());

        // then
        assertThat(outputMessage.toString()).isEqualToIgnoringNewLines("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}