import java.util.*;

public class GenerateTargetNumber {
    private int[] targetNumbers;

    public GenerateTargetNumber() {
        targetNumbers = generate();
    }

    private int[] generate() {
        Random random = new Random();
        Set<Integer> generated = new HashSet<>();

        while (generated.size() < 3) {
            int randomNumber = random.nextInt(9)+1;
            generated.add(randomNumber);
        }

        int[] result = new int[3];
        int index = 0;
        for (int num : generated) {
            result[index++] = num;
        }
        return result;
    }

    public int[] getTargetNumbers() {
        return targetNumbers;
    }
}
