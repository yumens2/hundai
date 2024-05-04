package domain;

import java.util.List;
import java.util.Scanner;
import Exception.*;
import util.ListGenerator;
import util.Printer;
import validate.RestartValidator;

public class Game {

    public int checkStrike(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = ListGenerator.getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i) == predictNumberList.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int checkBall(List<Integer> randomNumber, int predictNumber) {
        int count = 0;
        List<Integer> predictNumberList = ListGenerator.getIntegerList(predictNumber);
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(predictNumberList.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public void play(Computer computer, Scanner scanner) {
        List<Integer> randomNumber = computer.makeRandomNumber();
        boolean checkCorrect = false;
        while (!checkCorrect) {
            int predictNumber = Printer.inputNumber(scanner);
            int strike = checkStrike(randomNumber, predictNumber);
            int ball = checkBall(randomNumber, predictNumber) - strike;
            checkCorrect = Printer.printResult(strike, ball);
        }
    }

    public boolean restart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int checkRestart;
        try {
            checkRestart = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException();
        }
        RestartValidator.checkRestartNumber(checkRestart);
        if (checkRestart == 1) {
            return true;
        } else {
            return false;
        }
    }
}
