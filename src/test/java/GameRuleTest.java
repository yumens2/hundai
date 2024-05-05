import Model.BallCount;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.io.*;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;


public class GameRuleTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  private ByteArrayInputStream testIn;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }


  @ParameterizedTest(name = "{index}: {3}")
  @MethodSource("scoreCase")
  @DisplayName("score 함수 검사")
  void testScore(List<Integer> answer, List<Integer> guess, BallCount expected,
      String description) {
    BallCount result = GameRule.score(answer, guess);
    assertThat(result).usingRecursiveComparison().isEqualTo(expected);
  }

  static Stream<Arguments> scoreCase() {
    return Stream.of(
        Arguments.of(List.of(4, 2, 5), List.of(1, 2, 3), new BallCount(1, 0), "1스트라이크"),
        Arguments.of(List.of(4, 2, 5), List.of(1, 3, 4), new BallCount(0, 1), "1볼"),
        Arguments.of(List.of(4, 2, 5), List.of(4, 5, 6), new BallCount(1, 1), "1볼 1스트라이크"),
        Arguments.of(List.of(4, 2, 5), List.of(7, 8, 9), new BallCount(0, 0), "낫싱"),
        Arguments.of(List.of(4, 2, 5), List.of(4, 2, 5), new BallCount(3, 0), "3개의 숫자를 모두 맞히셨습니다.")
    );
  }

  @ParameterizedTest(name = "{index}: {2}")
  @MethodSource("resultPrint")
  @DisplayName("결과 print 함수 검사")
  void testResultPrint(BallCount bc, boolean isAnswer, String description) {
    boolean result = GameRule.printResult(bc);
    assertThat(result).isEqualTo(isAnswer);
    assertThat(outContent.toString().trim()).isEqualTo(description);
  }

  static Stream<Arguments> resultPrint() {
    return Stream.of(
        Arguments.of(new BallCount(0, 0), false, "낫싱"),
        Arguments.of(new BallCount(1, 0), false, "1스트라이크"),
        Arguments.of(new BallCount(0, 1), false, "1볼"),
        Arguments.of(new BallCount(1, 2), false, "2볼 1스트라이크"),
        Arguments.of(new BallCount(3, 0), true, "3스트라이크")
    );
  }

  @ParameterizedTest(name = "{index}: {4}")
  @MethodSource("restartOption")
  void testAskPlayContinue(String input, Boolean expectedGameWin, Boolean expectedGameActive,
      Class<? extends Exception> expectedException) {
    testIn = new ByteArrayInputStream(input.getBytes());
    System.setIn(testIn);
    Throwable thrown = catchThrowable(GameRule::askPlayContinue);
    if (expectedException == null) {
      assertThat(thrown).isNull();
      assertThat(GameRunner.gameWin).isEqualTo(expectedGameWin);
      assertThat(GameRunner.isGameActive).isEqualTo(expectedGameActive);
    } else {
      assertThat(thrown).isInstanceOf(expectedException);
    }
  }

  static Stream<Arguments> restartOption() {
    return Stream.of(
        Arguments.of("1", true, false, null),
        Arguments.of("2", true, false, null),
        Arguments.of("abc", null, null, IllegalArgumentException.class)
    );
  }

}

