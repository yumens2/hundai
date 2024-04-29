import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {
  @Test
  @DisplayName("잘못된 값을 추론했을때")
  void invalidGuess() {
    Integer[] guessInteger = { 1, 2, 3 };
    Integer[] answerInteger = { 3, 2, 1 };
    Assertions.assertThat(Baseball.guess(guessInteger, answerInteger)).isFalse();
  }

  @Test
  @DisplayName("올바른 값을 추론했을때")
  void validGuess() {
    Integer[] guessInteger = { 1, 2, 3 };
    Integer[] answerInteger = { 1, 2, 3 };
    Assertions.assertThat(Baseball.guess(guessInteger, answerInteger)).isTrue();
  }

  @Test
  @DisplayName("숫자가 아닌 값이 입력되었을때")
  void englishInput() {
    String input = "1ab";
    Assertions.assertThatThrownBy(() -> Baseball.parseGuess(input)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("세 자리 초과의 숫자가 입력되었을때")
  void longNumberInput() {
    String input = "1234";
    Assertions.assertThatThrownBy(() -> Baseball.parseGuess(input)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("세 자리 미만의 숫자가 입력되었을때")
  void shortNumberInput() {
    String input = "12";
    Assertions.assertThatThrownBy(() -> Baseball.parseGuess(input)).isInstanceOf(IllegalArgumentException.class);
  }
}
