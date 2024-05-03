package service;

import model.Hints;
import model.Number;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class GameService {

    private final RandomGenerator randomGenerator;
    private final Scanner sc;

    public GameService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.sc = new Scanner(System.in);
    }

    public int getInput() {

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

    }

    public static Number checkingCondition(int number) throws IllegalArgumentException {

        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("세자리 수를 입력해야 합니다.");
        }

        int first = number / 100;
        int second = (number / 10) % 10;
        int third = number % 10;

        if (first == second || first == third || second == third) {
            throw new IllegalArgumentException("각 자리의 수가 모두 달라야 합니다.");
        }

        return new Number(Stream.of(String.valueOf(number).split(""))
            .mapToInt(Integer::parseInt).toArray());

    }

    public Number getAnswer() {
        return randomGenerator.createNumber();
    }

    public Hints compareNumbers(int[] userInput, int[] answer) {
        int strike = 0;
        int ball = 0;
        boolean[] cnt = new boolean[10];

        for (int i = 0; i < 3; i++) {
            if (userInput[i] == answer[i]) {
                strike++;
            } else {
                cnt[answer[i]] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cnt[userInput[i]]) {
                ball++;
            }
        }

        return new Hints(strike, ball);
    }

    public boolean isAnswered(Hints hints) {
        return hints.getStrike() == 3 && hints.getBall() == 0;
    }

    public boolean isContinuing() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return getInput() == 1;
    }

    public void printHints(Hints hint) {

        if (hint.hasStrikesAndBalls()) {
            System.out.println(hint.getBall() + "볼 " + hint.getStrike() + "스트라이크");
        } else if (hint.hasStrikes()) {
            System.out.println(hint.getStrike() + "스트라이크");
        } else if (hint.hasBalls()) {
            System.out.println(hint.getBall() + "볼");
        } else {
            System.out.println("낫싱");
        }

    }

}
