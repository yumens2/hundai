import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

class ApplicationTest extends Application {
  @Test
  void testMain() {
  }

  @Test
  void testPlayGame() {
//    Application bg = new Application();
//    Scanner sc = new Scanner(System.in);
//    String answer="321";
//    bg.playGame(answer);
  }

  @Test
  void makeAnswer() {
    Application bg = new Application();
    System.out.println(bg.MakeAnswer());
  }

  @Test
  void judgeStrikeBall() {
    Application bg = new Application();
    String answer_string1 = "123";
    String input_n1="123"; //3스트라이크
    String input_n2="312"; //3볼
    String input_n3="132"; // 1스트라이크 2볼
    String input_n4="456"; //낫싱
    bg.JudgeStrikeBall(input_n1,answer_string1);
    bg.JudgeStrikeBall(input_n2,answer_string1);
    bg.JudgeStrikeBall(input_n3,answer_string1);
    bg.JudgeStrikeBall(input_n4,answer_string1);
  }

  @Test
  void testValidateInput() {
    Application bg = new Application();
//    bg.validateInput("1234"); //잘못 입력한 경우
    bg.validateInput("123"); //올바르게 입력한 경우
  }
}