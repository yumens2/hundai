import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    public Set<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            int number = 1 + random.nextInt(9);  // 1 to 9
            numbers.add(number);
        }
        return numbers;
    }
}
