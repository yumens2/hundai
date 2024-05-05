import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int Gaming = 1; // 1이면 게임 실행중 0이면 게임 종료
    String answer = MakeAnswer();
//    System.out.print("answer값 : ");
//    System.out.println(answer);

    while (Gaming == 1) {
      Gaming = playGame(answer);
    }

    sc.close();
  }

  public static int playGame(String answer) {
    System.out.print("숫자를 입력해주세요 : ");
    String inputV = sc.nextLine();

    try {
      validateInput(inputV);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return 0; // 게임 종료
    }

    JudgeStrikeBall(inputV, answer);

    if (inputV.equals(answer)) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      return sc.nextInt();
    }

    return 1; // 게임 진행
  }

  public static String MakeAnswer() {
    ArrayList<Integer> digits = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      digits.add(i);
    }
    Collections.shuffle(digits);
    StringBuilder answerBuilder = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      answerBuilder.append(digits.get(i));
    }
    return answerBuilder.toString();
  }

  public static void JudgeStrikeBall(String input_number, String answer_string) {
    int strike = 0;
    int ball = 0;
    for (int i = 0; i < answer_string.length(); i++) { // strike처리
      if (input_number.charAt(i) == answer_string.charAt(i)) {
        strike++;
      }
    }
    for (int i = 0; i < answer_string.length(); i++) { // ball처리
      if (answer_string.contains(Character.toString(input_number.charAt(i)))) {
        ball++;
      }
    }
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱\n");
    } else if (strike != 0 && ball == 0) {
      System.out.printf("%d스트라이크\n", strike);
    } else if (strike == 0 && ball != 0) {
      System.out.printf("%d볼\n", ball);
    } else {
      if (ball-strike==0){
        System.out.printf("%d스트라이크\n", strike);
      }else{
        System.out.printf("%d스트라이크 %d볼\n", strike, ball - strike);
      }
    }
  }

  public static void validateInput(String input) {
    if (!input.matches("[0-9]{3}")) {
      throw new IllegalArgumentException("입력한 값이 유효하지 않습니다.");
    }
  }
}
