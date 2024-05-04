package util;

import domain.Game;
import java.util.List;
import java.util.Scanner;
import validate.InputValidator;
import Exception.*;
public class Printer {

    private Printer() {

    }

    public static int inputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요 : ");
        int number;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException();
        }
        InputValidator.checkInvalidLength(number);
        InputValidator.checkDuplicate(number);
        InputValidator.checkZeroNumber(number);
        return number;
    }

    public static boolean printResult(int strike, int ball) {
        if (ball != 0) {
            System.out.println(ball + "볼 ");
        } else if (strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
            return false;
        } else {
            return false;
        }
    }
}
