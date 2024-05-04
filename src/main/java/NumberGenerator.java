import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private static final int LENGTH = 3;
    public static final int MIN = 1;
    public static final int MAX = 9;
    private static final Random random = new Random();

    public List<Integer> generateAnswer() {
        List<Integer> answers = new ArrayList<>();
        while (answers.size() < LENGTH) {
            int number = generateNumber();
            if (!answers.contains(number)) {
                answers.add(number);
            }
        }
        return answers;
    }

    private static int generateNumber() {
        return random.nextInt(MAX - MIN + 1) + MIN;
    }
}
