import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class play {

  public List<Integer> checkInput(String inputValue) {

    inputNum numToList = new inputNum();
    isCorrect chkInput = new isCorrect();
    boolean isValidInput = true;

    isValidInput = chkInput.isCorrectInput(inputValue);

    if (!isValidInput) {
      throw new IllegalArgumentException("wrong input");
    }

    return numToList.numToList(inputValue);
  }

  public boolean continueGame(int isContinue) {

    if (isContinue == 1) {
      return true;
    } else if (isContinue == 2) {
      return false;
    } else {
      throw new IllegalArgumentException("wrong input");
    }

  }

  public boolean playGame(List<Integer> computer) {

    Scanner sc = new Scanner(System.in);
    compare compareNum = new compare();
    String result = "낫싱";

    try {
      while (!Objects.equals(result, "3스트라이크")) {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputValue = sc.nextLine();
        List<Integer> user = checkInput(inputValue);
        result = compareNum.compareNum(computer, user);
        System.out.println(result);
      }

      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      
      int isContinue = sc.nextInt();
      return continueGame(isContinue);

    } catch (IllegalArgumentException e) {
      System.out.println(e);
      return false;
    }
  }
}
