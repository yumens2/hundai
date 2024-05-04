import Model.BallCount;
import java.util.List;
import java.util.Scanner;

public class GameRule {

  /// 숫자에 대한 결과
  public static BallCount score(List answer, List guess) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < 3; i++) {
      if (guess.get(i) == answer.get(i)) {
        strike++;
      } else if (answer.contains(guess.get(i))) {
        ball++;
      }
    }

    return new BallCount(strike, ball);
  }

  /// 결과 print
  public static boolean printResult(BallCount bc) {
    if (bc.getBall() == 0 && bc.getStrike() == 0) {
      System.out.println("낫싱");
    } else {
      if (bc.getBall() != 0 && bc.getStrike() != 0) {
        System.out.println(bc.getBall() + "볼 " + bc.getStrike() + "스트라이크");
      } else if (bc.getBall() == 0) {
        System.out.println(bc.getStrike() + "스트라이크");
      } else if (bc.getStrike() == 0) {
        System.out.println(bc.getBall() + "볼");
      }
    }
    return bc.getStrike() == 3;
  }


  /// 계속 진행할지말지
  public static void askPlayContinue() {
    Scanner userContinue = new Scanner(System.in);
    String continueNumber;

    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    while (true) {
      System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      continueNumber = userContinue.nextLine();

      switch (continueNumber) {
        case "1":
          GameRunner.gameWin = true;
          return;
        case "2":
          GameRunner.gameWin = true;
          GameRunner.isGameActive = false;
          return;
        default:
          System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
      }
    }
  }


}
