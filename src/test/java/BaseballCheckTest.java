import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import model.Baseball;
import model.BaseballService;
import model.BaseballServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballCheckTest {

  BaseballService baseballService;

  @Test
  @DisplayName("낫싱 출력")
  void print_nothing() {
    // given
    Baseball baseball = new Baseball();
    String[] answer = {"1", "2", "3"};
    String[] submit = {"4", "5", "6"};
    baseball.setAnswer(answer);
    baseball.setSubmit(submit);
    String output = "낫싱";
    PrintStream standardOut = System.out;
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(captor));
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.check();
    //then
    System.setOut(standardOut);
    String result = captor.toString().trim();
    Assertions.assertThat(output).isEqualTo(result);
  }

  @Test
  @DisplayName("스트라이크 출력")
  void print_strike() {
    // given
    Baseball baseball = new Baseball();
    String[] answer = {"1", "2", "3"};
    String[] submit = {"1", "2", "4"}; // 2스트라이크
    baseball.setAnswer(answer);
    baseball.setSubmit(submit);
    String output = "2스트라이크";
    PrintStream standardOut = System.out;
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(captor));
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.check();
    //then
    System.setOut(standardOut);
    String result = captor.toString().trim();
    Assertions.assertThat(output).isEqualTo(result);
  }

  @Test
  @DisplayName("볼 출력")
  void print_ball() {
    // given
    Baseball baseball = new Baseball();
    String[] answer = {"1", "2", "3"};
    String[] submit = {"4", "1", "2"}; // 2볼
    baseball.setAnswer(answer);
    baseball.setSubmit(submit);
    String output = "2볼";
    PrintStream standardOut = System.out;
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(captor));
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.check();
    //then
    System.setOut(standardOut);
    String result = captor.toString().trim();
    Assertions.assertThat(output).isEqualTo(result);
  }

  @Test
  @DisplayName("스트라이크, 볼 출력")
  void print_strike_ball() {
    // given
    Baseball baseball = new Baseball();
    String[] answer = {"1", "2", "3"};
    String[] submit = {"1", "3", "2"}; // 2볼 1스트라이크
    baseball.setAnswer(answer);
    baseball.setSubmit(submit);
    String output = "2볼 1스트라이크";
    PrintStream standardOut = System.out;
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(captor));
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.check();
    //then
    System.setOut(standardOut);
    String result = captor.toString().trim();
    Assertions.assertThat(output).isEqualTo(result);
  }

  @Test
  @DisplayName("3스트라이크 출력")
  void print_3strike() {
    // given
    Baseball baseball = new Baseball();
    String[] answer = {"1", "2", "3"};
    String[] submit = {"1", "2", "3"}; // 3스트라이크
    baseball.setAnswer(answer);
    baseball.setSubmit(submit);
    String output = "3스트라이크";
    PrintStream standardOut = System.out;
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(captor));
    Scanner scanner = new Scanner(System.in);
    baseballService = new BaseballServiceImpl(baseball, scanner);
    //when
    baseballService.check();
    //then
    System.setOut(standardOut);
    String result = captor.toString().trim();
    Assertions.assertThat(output).isEqualTo(result);
  }
}

