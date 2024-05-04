package baseball.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static List<Integer> parseAnswer(String input) {
        return Arrays.stream(input.split(""))
            .mapToInt(Integer::parseInt)
            .boxed().collect(Collectors.toList());
    }
}
