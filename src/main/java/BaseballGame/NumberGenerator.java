package BaseballGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public String generateNumber() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        return String.valueOf(numbers.get(0) * 100 + numbers.get(1) * 10 + numbers.get(2));
    }
}