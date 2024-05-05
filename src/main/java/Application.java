import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
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

    protected int[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("숫자는 3자리로 입력해야 합니다.");
        }

        int[] userInput = new int[DIGIT_COUNT];
        for (int i = 0; i < DIGIT_COUNT; i++) {
            char digitChar = input.charAt(i);
            if (!Character.isDigit(digitChar)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
            userInput[i] = Character.getNumericValue(digitChar);
        }
        return userInput;
    }

    protected void compareAndPrintResult(int[] userInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (userInput[i] == computerNumber[i]) {
                strikes++;
            } else if (contains(computerNumber, userInput[i])) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱\n");
        } else {
            System.out.print(strikes + "스트라이크 " + balls + "볼\n");
        }
    }

    protected boolean isGameEnd(int[] userInput) {
        return Arrays.equals(userInput, computerNumber);
    }

    protected boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Application game = new Application();
        // game.start();
    }
}
