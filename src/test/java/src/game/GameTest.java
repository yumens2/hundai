package src.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.io.Input;

class GameTest {

    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private void userInput(String userInputStr) {
        InputStream in = new ByteArrayInputStream(userInputStr.getBytes());
        game = new Game(new Input(in));
    }

    @ParameterizedTest(name = "게임 재시작 및 종료 - [{0}]: {1}")
    @MethodSource("provideUserInputsAndExpectedStates")
    @DisplayName("게임 재시작 및 종료 테스트")
    void gameRestartAndExitTest(String userInputStr, GameState expectedState) {
        //given
        userInput(userInputStr);

        //when
        game.updateGameState();

        //then
        assertThat(game.getState()).isEqualTo(expectedState);
    }

    private static Stream<Arguments> provideUserInputsAndExpectedStates() {
        return Stream.of(
                Arguments.of("1", GameState.RESTART),
                Arguments.of("2", GameState.EXIT)
        );
    }
}