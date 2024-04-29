import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baseball {
  private static final Integer NUM_LEN = 3;

  public static Integer[] initAnswerNums() {
    Integer availableNums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Integer answerNums[] = new Integer[NUM_LEN];
    List<Integer> list = Arrays.asList(availableNums);
    Collections.shuffle(list);

    for (int index = 0; index < NUM_LEN; index++) {
      answerNums[index] = list.get(index);
    }
    return answerNums;
  }

  private static void printGuessResult(Integer strike, Integer ball) {
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
    } else if (strike == 0) {
      System.out.println(ball + " 볼");
    } else if (ball == 0) {
      System.out.println(strike + " 스트라이크");
    } else {
      System.out.println(ball + " 볼, " + strike + " 스트라이크");
    }
    if (strike == NUM_LEN) {
      System.out.println(NUM_LEN + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
  }

  public static boolean guess(Integer[] guessIntegers, Integer[] answerIntegers) {
    Integer strike = 0;
    Integer ball = 0;
    for (int index = 0; index < NUM_LEN; index++) {
      if (answerIntegers[index] == guessIntegers[index]) {
        strike++;
      } else if (Arrays.asList(answerIntegers).contains(guessIntegers[index])) {
        ball++;
      }
    }
    printGuessResult(strike, ball);

    if (strike == NUM_LEN) {
      return true;
    }
    return false;
  }

  public static Integer[] parseGuess(String input) {
    try {
      Integer guessIntegers[] = new Integer[NUM_LEN];
      int parsedInput = Integer.parseInt(input);
      if (parsedInput < 100 || parsedInput > 999) {
        throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
      }
      for (int index = 0; index < NUM_LEN; index++) {
        guessIntegers[index] = parsedInput / (int) Math.pow(10, NUM_LEN - index - 1) % 10;
      }

      return guessIntegers;
    } catch (Error e) {
      throw new IllegalArgumentException("잘못된 입력입니다.");
    }
  }

  public void execute() {
    Scanner scanner = new Scanner(System.in);
    Integer answerNums[] = initAnswerNums();
    while (true) {
      System.out.print("숫자를 입력해주세요 : ");
      String input = scanner.next();
      try {
        Integer guessNums[] = parseGuess(input);

        boolean canEndGame = guess(guessNums, answerNums);
        if (canEndGame) {
          System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
          Integer restartOrEnd = scanner.nextInt();
          if (restartOrEnd == 1) {
            answerNums = initAnswerNums();
          } else {
            break;
          }
        }
      } catch (IllegalArgumentException e) {
        scanner.close();
        return;
      }
    }
    scanner.close();
  }
}
