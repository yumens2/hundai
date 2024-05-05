import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private List<Integer> numbers;
    private final Random random;

    public Computer() {
        random = new Random();
        generateNumbers();
    }

    private void generateNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randNum = random.nextInt(9) + 1;
            if (!numbers.contains(randNum)) {
                numbers.add(randNum);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
