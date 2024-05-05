package io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {

    private static final int DIGIT = 3;
    private static final String INPUT_PROMPT = "숫자를 입력해 주세요 : ";
    private static final String RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> RESTART_OPTION = Arrays.asList("1", "2");

    public List<Integer> inputGuess() {
        System.out.print(INPUT_PROMPT);
        return validateGuessAndParse(scanner.nextLine());
    }

    public int inputRestartOption() {
        System.out.println(RESTART_PROMPT);
        return validateRestartOptionAndParse(scanner.nextLine());
    }

    private static List<Integer> validateGuessAndParse(String inputString) {
        List<Integer> inputNumbers = isNumber(inputString);
        if (hasLengthOf(inputNumbers) && doesNotContainZero(inputNumbers) && isDistinct(inputNumbers)) {
            return inputNumbers;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    private static int validateRestartOptionAndParse(String inputString) {
        if (!RESTART_OPTION.contains(inputString)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    private static List<Integer> isNumber(String inputString) {
        try {
            return Stream.of(inputString.split(""))
                    .map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasLengthOf(List<Integer> inputNumbers) {
        return inputNumbers.size() == DIGIT;
    }

    private static boolean doesNotContainZero(List<Integer> inputNumbers) {
        return !inputNumbers.contains(0);
    }

    private static boolean isDistinct(List<Integer> inputNumbers) {
        return inputNumbers.stream().distinct().count() == inputNumbers.size();
    }
}
