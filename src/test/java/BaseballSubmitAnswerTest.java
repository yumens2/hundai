import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import model.Baseball;
import model.BaseballService;
import model.BaseballServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballSubmitAnswerTest {

  BaseballService baseballService;

  @Test
  @DisplayName("사용자 입력값 테스트")
  public void inputTest() {
    //given
    String input = "test";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    //when
    Scanner scanner = new Scanner(System.in);
    //then
    Assertions.assertThat(input).isEqualTo(scanner.next());
  }

  @Test
  @DisplayName("유효하지 않은 input : 길이가 3보다 짧은 경우")
  void invalid_input_1() {
    //given
    String s = "1";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> {
      baseballService.play();
    });
  }

  @Test
  @DisplayName("유효하지 않은 input : 길이가 3보다 긴 경우")
  void invalid_input_2() {
    //given
    String s = "1234";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> {
      baseballService.play();
    });
  }

  @Test
  @DisplayName("유효하지 않은 input : 숫자가 아닌 문자가 들어온 경우")
  void invalid_input_3() {
    //given
    String s = "abc";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> {
      baseballService.play();
    });
  }

  @Test
  @DisplayName("유효한 input")
  void valid_input() {
    //given
    String s = "123";
    InputStream in = new ByteArrayInputStream(s.getBytes());
    System.setIn(in);
    Baseball baseball = new Baseball();
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.submitAnswer();
    String[] submit = baseball.getSubmit();
    String joined = String.join("", submit);
    System.out.println(joined);
    //then
    Assertions.assertThat(s).isEqualTo(joined);
  }
}
