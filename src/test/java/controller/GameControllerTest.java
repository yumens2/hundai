package controller;

import exception.DuplicateNumberException;
import exception.InvalidLengthException;
import exception.InvalidRestartStateException;
import exception.NonNumericValueException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import view.InputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalIn = System.in;

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void gameStart_no_restart() {
        // given
        systemIn("213\n123\n2\n");
        List<String> answers = Arrays.asList("123");

        // when
        GameController.gameStart(answers);

        // then
        assertEquals("숫자를 입력해 주세요 : 2볼 1스트라이크 \n숫자를 입력해 주세요 : 3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outContent.toString());
    }

    @Test
    void gameStart_restart() {
        // given
        systemIn("213\n123\n1\n123\n457\n458\n2\n");
        List<String> answers = Arrays.asList("123", "458");

        // when
        GameController.gameStart(answers);

        // then
        assertEquals("숫자를 입력해 주세요 : 2볼 1스트라이크 \n숫자를 입력해 주세요 : 3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n숫자를 입력해 주세요 : 낫싱 \n숫자를 입력해 주세요 : 2스트라이크 \n숫자를 입력해 주세요 : 3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outContent.toString());

    }

    @Test
    void gameStart_InvalidRestartState() {
        // given
        systemIn("213\n123\n3\n");
        List<String> answers = Arrays.asList("123");

        // then
        // exception
        assertThrows(InvalidRestartStateException.class, () -> {
            GameController.gameStart(answers);
        });
    }

    @Test
    void gameStrat_NonNumericInput() {
        // given
        systemIn("hello\n");
        List<String> answers = Arrays.asList("123");

        // then
        // exception
        assertThrows(NonNumericValueException.class, () -> {
            GameController.gameStart(answers);
        });
    }

    @Test
    void gameStrat_InvalidNumberInput() {
        // given
        systemIn("213\n12\n1\n");
        List<String> answers = Arrays.asList("123");

        // then
        // exception
        assertThrows(InvalidLengthException.class, () -> {
            GameController.gameStart(answers);
        });
    }

    @Test
    void gameStrat_DuplicateNumberInput() {
        // given
        systemIn("223\n123\n1\n");
        List<String> answers = Arrays.asList("123");

        // then
        // exception
        assertThrows(DuplicateNumberException.class, () -> {
            GameController.gameStart(answers);
        });
    }

    private void systemIn(String input) {
        InputView.setScanner(new Scanner(new ByteArrayInputStream(input.getBytes())));
    }

}