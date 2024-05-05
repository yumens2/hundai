import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {

    private int[] answer = new int[GameConstant.NUMBER_COUNT];

    public Player() {
        createRandomAnswer();
    }

    private void createRandomAnswer() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < GameConstant.NUMBER_COUNT) {
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
