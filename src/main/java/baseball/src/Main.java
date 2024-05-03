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
    }

    private static int[] getUserNumbers(Scanner scanner) {
        int[] numbers = new int[DIGIT_COUNT];
        System.out.print("숫자를 입력해 주세요: ");
        String input = scanner.next();
        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("숫자의 길이가 올바르지 않습니다.");
        }
        for (int i = 0; i < DIGIT_COUNT; i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            numbers[i] = Character.getNumericValue(ch);
            if (numbers[i] < MIN_NUMBER || numbers[i] > MAX_NUMBER) {
                throw new IllegalArgumentException("숫자가 범위를 벗어납니다.");
            }
        }
        return numbers;
    }//2,3
}


