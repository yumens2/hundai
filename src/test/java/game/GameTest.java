package game;

import io.ConsoleInput;
import io.ConsoleOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        System.setIn(generateUserInput("123\n/2"));
        Scanner scanner = new Scanner(System.in);
        Game game = new RandomGame(new ConsoleInput(scanner), new ConsoleOutput());
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("숫자를 입력해 주세요 : "));
    }

    @DisplayName("잘못된 더 큰 입력 테스트")
    @Test
    void testWrongBiggerInput() {
        System.setIn(generateUserInput("1234"));
        Scanner scanner = new Scanner(System.in);
        Game game = new RandomGame(new ConsoleInput(scanner), new ConsoleOutput());
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
    }

    @DisplayName("잘못된 더 작은 입력 테스트")
    @Test
    void testWrongSmallerInput() {
        System.setIn(generateUserInput("12"));
        Scanner scanner = new Scanner(System.in);
        Game game = new RandomGame(new ConsoleInput(scanner), new ConsoleOutput());
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
    }

    @DisplayName("숫자가 아닌 입력 테스트")
    @Test
    void testNotNumberInput() {
        System.setIn(generateUserInput("a78"));
        Scanner scanner = new Scanner(System.in);
        Game game = new RandomGame(new ConsoleInput(scanner), new ConsoleOutput());
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
    }

    @DisplayName("1스트라이크 테스트")
    @Test
    void testOneStrike() {
        System.setIn(generateUserInput("123\n/2\n"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),156);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("1스트라이크"));
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void testOneStrikeOneBall() {
        System.setIn(generateUserInput("152\n/2\n"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),126);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("1볼 1스트라이크"));
    }

    @DisplayName("1스트라이크 2볼 테스트")
    @Test
    void testOneStrikeTwoBall() {
        System.setIn(generateUserInputs("162\n/2\n"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),126);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("2볼 1스트라이크"));
    }

    @DisplayName("2스트라이크 테스트")
    @Test
    void testTwoStrike() {
        System.setIn(generateUserInputs("739\n/2\n"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),738);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("2스트라이크"));
    }

    @DisplayName("3스트라이크 테스트")
    @Test
    void testThreeStrike() {
        System.setIn(generateUserInputs("738\n/2"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),738);
        game.play();
        assertTrue(outputStream.toString().contains("3개의 숫자를 모두 맞히셨습니다! " +
                "게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
    }

    @DisplayName("낫싱 테스트")
    @Test
    void testNothing() {
        System.setIn(generateUserInputs("126\n/2"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),738);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
        assertTrue(outputStream.toString().contains("낫싱"));
    }

    @DisplayName("잘못된 새로 시작 입력 테스트")
    @Test
    void testWrongNewStartInput() {
        System.setIn(generateUserInputs("738\n/3\n"));
        Scanner scanner = new Scanner(System.in);
        Game game = new DeterminedGame(new ConsoleInput(scanner), new ConsoleOutput(),738);
        assertThrows(IllegalArgumentException.class, () -> {
            game.play();
        });
    }
}
