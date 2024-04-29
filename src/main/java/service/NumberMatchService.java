package service;

import util.ConsoleMessages;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class NumberMatchService {

    private NumberMatchService() {
    }

    static public boolean isMatch(List<Integer> computerNumbers,List<Integer> userNumbers) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);
            boolean hasNumber = computerNumbers.contains(userNumber);
            boolean isSameLocation = computerNumbers.get(i) == userNumbers.get(i);
            if (hasNumber && isSameLocation) {
                ++strikeCount;
            } else if (hasNumber && !isSameLocation) {
                ++ballCount;
            }
        }

        if (ballCount == 0 && strikeCount == 0) {
            nothing();
            return false;

        } else if (ballCount > 0 && strikeCount > 0) {
            ballAndStrike(ballCount, strikeCount);
            return false;
        } else if (ballCount > 0) {
            onlyBall(ballCount);
            return false;
        } else if (strikeCount > 0) {
            onlyStrike(strikeCount);
            return false;
        }
        return true;
    }

    public static void run(List<Integer> computerNumbers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            ConsoleMessages.requestNumberInput();
            List<Integer> userNumbers= InputValidator.validateThreeUniqueNumbers(scanner.next());
            if(isMatch(computerNumbers, userNumbers)) break;
        }
    }


    private static void ballAndStrike(int ballCount, int strikeCount) {
        ConsoleMessages.ball(ballCount);
        ConsoleMessages.strike(strikeCount);
        System.out.println();
    }

    private static void onlyBall(int ballCount) {
        ConsoleMessages.ball(ballCount);
        System.out.println();
    }

    private static void onlyStrike(int strikeCount) {
        ConsoleMessages.strike(strikeCount);
        System.out.println();
    }

    private static void nothing() {
        ConsoleMessages.nothing();
        System.out.println();
    }
}
