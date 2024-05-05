import java.util.*;

public class Computer {

    public static List<Integer> generateNum() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }
}
