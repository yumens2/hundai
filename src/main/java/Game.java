import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    public int checkStrike(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i) == predictNumberList.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int checkBall(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(predictNumberList.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public int inputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        int number = scanner.nextInt();
        return number;
    }

    public boolean printResult(List<Integer> randomNumber, int predictNumber) {
        int strike = checkStrike(randomNumber, predictNumber);
        int ball = checkBall(randomNumber, predictNumber) - strike;

        if (ball != 0) {
            System.out.println(ball + "볼 ");
        } else if (strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            System.out.println(strike + "스트라이크");
            return false;
        }
    }

    public void play(Computer computer, Scanner scanner) {
        List<Integer> randomNumber = computer.makeRandomNumber();
        boolean checkCorrect = false;
        while (!checkCorrect) {
            int predictNumber = inputNumber(scanner);
            checkCorrect = printResult(randomNumber, predictNumber);
        }
    }

    public boolean restart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int checkRestart = scanner.nextInt();
        if (checkRestart == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static List<Integer> getIntegerList(int predictNumber) {
        String number = Integer.toString(predictNumber);
        List<String> numberList = Arrays.asList(number.split(""));
        List<Integer> predictNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            predictNumberList.add(Integer.valueOf(numberList.get(i)));
        }
        return predictNumberList;
    }
}
