package kim.half.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballFactory {

    private static final char ZERO_CHAR = '0';
    private static final int VALID_BASEBALLS_SIZE = 3;
    private static final int RANDOM_NUMBER_ORIGIN = 1;
    private static final int RANDOM_NUMBER_BOUND = 10;

    public static Baseballs generateRandomBaseballs() {
        return BaseballFactory.createRandomBaseballs();
    }

    public static Baseballs createBaseballs(String baseballNumbers) {
        List<Baseball> baseballs = new ArrayList<>();

        for (int i = 0; i < baseballNumbers.length(); i++) {
            baseballs.add(createBaseball(baseballNumbers.charAt(i) - ZERO_CHAR));
        }
        return new Baseballs(baseballs);
    }

    public static Baseballs createRandomBaseballs() {
        List<Baseball> baseballs = new ArrayList<>();

        new Random().ints(RANDOM_NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
            .distinct()
            .limit(VALID_BASEBALLS_SIZE)
            .forEach(randomNumber -> baseballs.add(createBaseball(randomNumber)));
        return new Baseballs(baseballs);
    }

    private static Baseball createBaseball(int number) {
        return new Baseball(number);
    }
}
