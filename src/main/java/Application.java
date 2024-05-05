import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Application {

    protected static final int DIGIT_COUNT = 3;
    protected static final int MIN_DIGIT = 1;
    protected static final int MAX_DIGIT = 9;

    protected int[] computerNumber;

    public Application() {
        initialize();
    }

    protected void initialize() {
        Random random = new Random();
        computerNumber = new int[DIGIT_COUNT];
        Set<Integer> selectedNumbers = new HashSet<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(MAX_DIGIT - MIN_DIGIT + 1) + MIN_DIGIT;
            } while (selectedNumbers.contains(randomNumber));

            computerNumber[i] = randomNumber;
            selectedNumbers.add(randomNumber);
        }
    }
    public static void main(String[] args) {
        Application game = new Application();
        // game.start();
    }
}
