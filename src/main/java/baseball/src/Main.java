import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;


    private static int[] generateComputerNumbers() {
        int[] numbers = new int[DIGIT_COUNT];
        Random random = new Random();
        for (int i = 0; i < DIGIT_COUNT; i++) {
            numbers[i] = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    } //1
}

