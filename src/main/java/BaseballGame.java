import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BaseballGame {
    public void startGame() {
        System.out.println("Game started");
        playGame();
    }

    public void playGame() {
        int[] targetNumbers = generateRandomNumbers();
        int[] userInput = getUserInput();
        System.out.println(Arrays.toString(targetNumbers));
        System.out.println(Arrays.toString(userInput));
    }

    public static int[] generateRandomNumbers() {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = digits.get(i);
        }
        return result;
    }

    public int[] getUserInput() {
        System.out.println("세 자리 숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] inputArray = input.split("");
        int[] intArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            intArray[i] = Integer.parseInt(inputArray[i]);
        }

        return intArray;
    }
}
