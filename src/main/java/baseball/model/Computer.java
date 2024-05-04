package baseball.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Computer {
    private static final int MAX_VAL = 9;
    private static final int MIN_VAL = 1;

    public static final int LENGTH = 3;
    public static List<Integer> getComputerNumbers() {
        return createNumbers();
    }

    private static List<Integer> createNumbers() {
        List<Integer> numbers = randomNumbers();
        while(repeatedNumbers(numbers)) {
            numbers = randomNumbers();
        }
        return numbers;
    }

    private static List<Integer> randomNumbers() {
        return new Random().ints(MIN_VAL, MAX_VAL + 1)
                .distinct()
                .limit(LENGTH)
                .boxed()
                .collect(Collectors.toList());
    }



    private static boolean repeatedNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() != 3;
    }
}
