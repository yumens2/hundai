import Model.BallCount;
import java.util.List;

public class GameRule {

  public static void score(List answer, List guess) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < 3; i++) {
      if (guess.get(i) == answer.get(i)) {
        strike++;
      } else if (answer.contains(guess.get(i))) {
        ball++;
      }
    }

    printResult(new BallCount(strike, ball));
  }


  public static void printResult(BallCount bc) {
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

      if (bc.getStrike() == 3) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      }
    }
  }


}
