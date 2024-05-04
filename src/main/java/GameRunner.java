import Model.BallCount;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

  /// 컴퓨터가 설장한 3개의 숫자
  public static List<Integer> answer;

  /// 게임이 진행중인지 아닌지
  static boolean isGameActive = false;

  /// 숫자를 맞추었는지 여부
  static boolean gameWin = false;


  public static void startGame() {
    isGameActive = true;
    while (isGameActive) {
      gameWin = false;
      System.out.println("숫자 야구 게임을 시작합니다.");
      //    answer = NumberGenerator.generateRandomNumber();
      answer = List.of(4, 2, 5);
      System.out.println("컴퓨터가 중복되지 않는 3자리 숫자를 무작위로 생성했습니다.");

      while (!gameWin){
        System.out.print("숫자를 입력해주세요 : ");

        Scanner scan = new Scanner(System.in);
        String userGuess = scan.nextLine();
        List<Integer> guess = InputValidator.validate(userGuess);

        if (GameRule.printResult(GameRule.score(answer, guess))) {
          GameRule.askPlayContinue();
        }
      }

    }


  }
}
