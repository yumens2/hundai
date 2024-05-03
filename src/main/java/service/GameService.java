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

    public Number checkingCondition(int number) throws IllegalArgumentException {

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


}
