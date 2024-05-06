import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    public static int[] generate(int length) {
        int[] result = new int[length];
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < length) {
            int number = createRandomNumber();
            numbers.add(number);
        }
        int index = 0;
        for (int number : numbers) {
            result[index++] = number;
        }
        return result;
    }

    private static int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
