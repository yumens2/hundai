package io;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {

    private static final int DIGIT = 3;
    private static final String INPUT_PROMPT = "숫자를 입력해 주세요 : ";
    private static final Scanner scanner = new Scanner(System.in);

    public String input() {
        System.out.print(INPUT_PROMPT);
        return scanner.nextLine();
    }

    public List<Integer> validateAndParse(String inputString) {
        List<Integer> inputNumbers = isNumber(inputString);
        if (hasLengthOf(inputNumbers) && doesNotContainZero(inputNumbers) && isDistinct(inputNumbers)) {
            return inputNumbers;
        }
        else {
            throw new IllegalArgumentException();
        }
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
