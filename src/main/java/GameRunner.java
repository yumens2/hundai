import Model.BallCount;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

  public static List<Integer> answer;

  public static void startGame() {
    System.out.println("숫자 야구 게임을 시작합니다.");
//    answer = NumberGenerator.generateRandomNumber();
    answer = List.of(4, 2, 5);
    System.out.println("컴퓨터가 중복되지 않는 3자리 숫자를 무작위로 생성했습니다.");
    System.out.print("숫자를 입력해주세요 : ");
    Scanner scan = new Scanner(System.in);
    String userGuess = scan.nextLine();
    List<Integer> guess = InputValidator.validate(userGuess);

    GameRule.score(answer, guess);

  }
}
