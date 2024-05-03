import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = new Random().nextInt(9) + 1;
            if (numbers.contains(num)) {
                continue;
            } else {
                numbers.add(num);
            }
        }
        return numbers;
    }
}
