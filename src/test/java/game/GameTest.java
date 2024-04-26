package game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUpStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static InputStream generateUserInputs(String input) {
        List<InputStream> streams = new ArrayList<>();
        for (String token : input.split("/"))
            streams.add(generateUserInput(token));
        return new SequenceInputStream(Collections.enumeration(streams));
    }

    @DisplayName("입력 도움말 출력 테스트")
    @Test
    void testShowInputHelp() {
        Game game = new RandomGame();
        game.play();
        assertEquals("숫자를 입력해 주세요 : ", outputStream.toString());
    }

    @DisplayName("잘못된 더 큰 입력 테스트")
    @Test
    void testWrongBiggerInput() {
        Game game = new RandomGame();
        game.play();
        assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(generateUserInput("1234"));
        });
    }

    @DisplayName("잘못된 더 작은 입력 테스트")
    @Test
    void testWrongSmallerInput() {
        Game game = new RandomGame();
        game.play();
        assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(generateUserInput("12"));
        });
    }

    @DisplayName("숫자가 아닌 입력 테스트")
    @Test
    void testNotNumberInput() {
        Game game = new RandomGame();
        game.play();
        assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(generateUserInput("a78"));
        });
    }

    @DisplayName("1스트라이크 테스트")
    @Test
    void testOneStrike() {
        Game game = new DeterminedGame(145);
        game.play();
        System.setIn(generateUserInput("123"));
        assertTrue(outputStream.toString().contains("1스트라이크"));
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void testOneStrikeOneBall() {
        Game game = new DeterminedGame(126);
        game.play();
        System.setIn(generateUserInput("152"));
        assertTrue(outputStream.toString().contains("1볼 1스트라이크"));
    }

    @DisplayName("1스트라이크 2볼 테스트")
    @Test
    void testOneStrikeTwoBall() {
        Game game = new DeterminedGame(126);
        game.play();
        System.setIn(generateUserInput("162"));
        assertTrue(outputStream.toString().contains("2볼 1스트라이크"));
    }

    @DisplayName("2스트라이크 테스트")
    @Test
    void testTwoStrike() {
        Game game = new DeterminedGame(738);
        game.play();
        System.setIn(generateUserInput("739"));
        assertTrue(outputStream.toString().contains("2스트라이크"));
    }

    @DisplayName("3스트라이크 테스트")
    @Test
    void testThreeStrike() {
        Game game = new DeterminedGame(738);
        game.play();
        System.setIn(generateUserInput("738"));
        assertTrue(outputStream.toString().contains("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! " +
                "게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
    }

    @DisplayName("잘못된 새로 시작 입력 테스트")
    @Test
    void testWrongNewStartInput() {
        Game game = new DeterminedGame(738);
        game.play();
        assertThrows(IllegalArgumentException.class, () -> {
            System.setIn(generateUserInputs("738\n/3\n"));
        });
    }
}
