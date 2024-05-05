import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseballGame {

    private final int NUMBER_COUNT = 3;
    private int[] answer = new int[NUMBER_COUNT];

    public BaseballGame() {

    }

    public void init() {
        createRandomAnswer();
    }

    private void createRandomAnswer() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_COUNT) {
            int number = createRandomNumber();
            numbers.add(number);
        }
        int index = 0;
        for (int number : numbers) {
            answer[index++] = number;
        }
    }

    private int createRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
