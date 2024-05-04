package model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class BaseballServiceImpl implements BaseballService {

  private final Baseball baseball;
  private final Scanner scanner;

  public BaseballServiceImpl(Baseball baseball, Scanner scanner) {
    this.baseball = baseball;
    this.scanner = scanner;
  }

  @Override
  public void baseballInit() {
    String[] randomNumber = new String[3];
    int[] numberCheck = new int[10];
    Arrays.fill(numberCheck, 0);
    for (int i = 0; i < 3; i++) {
      int temp = (int) (Math.random() * 10);
      if (numberCheck[temp] == 0) {
        numberCheck[temp] = 1;
        randomNumber[i] = Integer.toString(temp);
      } else {
        i--;
      }
    }
    baseball.setAnswer(randomNumber);
    baseball.setFinish(false);
  }

  @Override
  public void play() {
    baseballInit();
    // answer 찾으면 break
    while (!baseball.isFinish()) {
      submitAnswer(); // 입력 받기 + 유효성 검사
      check(); // ball, strike, nothing 체크
    }
    replay();
  }

  @Override
  public void replay() {
    String replayStatus;
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    replayStatus = scanner.next();
    if (replayStatus.equals("1")) {
      play();
    } else if (replayStatus.equals("2")) {
      scanner.close();
    } else {
      throw new IllegalArgumentException("Invalid Arguments");
    }
  }

  @Override
  public void check() {
    int strike, ball;
    String[] submit = baseball.getSubmit();
    String[] answer = baseball.getAnswer();

    strike = ball = 0;

    for (int i = 0; i < 3; i++) {
      if (submit[i].equals(answer[i])) {
        strike++;
      } else if (Arrays.asList(answer).contains(submit[i])) {
        ball++;
      }
    }

    if (strike == 3) {
      baseball.setFinish(true);
    }

    if (strike > 0 && ball > 0) {
      System.out.printf("%d볼 %d스트라이크%n", ball, strike);
    } else if (strike > 0) {
      System.out.printf("%d스트라이크%n", strike);
    } else if (ball > 0) {
      System.out.printf("%d볼%n", ball);
    } else {
      System.out.println("낫싱");
    }
  }

  @Override
  public void submitAnswer() {
    System.out.print("숫자를 입력해 주세요 : ");
    String temp_submit = scanner.next();
    if (!isValid(temp_submit)) {
      throw new IllegalArgumentException("Invalid Arguments");
    } else {
      String[] submit = new String[3];
      for (int i = 0; i < 3; i++) {
        submit[i] = Character.toString(temp_submit.charAt(i));
      }
      baseball.setSubmit(submit);
    }
  }

  @Override
  public boolean isValid(String submit) {
    if (submit.length() != 3) {
      return false;
    }
    for (int i = 0; i < 3; i++) {
      char c = submit.charAt(i);
      if (c < '0' || c > '9') {
        return false;
      }
    }
    return true;
  }
}
