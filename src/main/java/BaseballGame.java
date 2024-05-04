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
        int[] comparedResult = compareNumbers(targetNumbers, userInput);
        System.out.println(getResultMessage(comparedResult));


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


    public String getResultMessage(int[] comparedResult) {
        String message = "";
        int strikeCount = comparedResult[0];
        int ballCount = comparedResult[1];

        if (strikeCount == 3) {
            message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            return message;
        }
        if (strikeCount == 0 && ballCount == 0) {
            message = "낫싱";
            return message;
        }
        if (strikeCount > 0 && ballCount == 0) {
            message = String.format("%d스트라이크", strikeCount);
            return message;
        }
        if (strikeCount == 0 && ballCount > 0) {
            message = String.format("%d볼", ballCount);
            return message;
        }
        message = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        return message;

    }

    public int[] compareNumbers(int[] target, int[] userInput) {
        // 배열의 첫번쨰 자리에는 strike 개수, 두번째 자리에는 ball 개수
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (target[i] == userInput[j] && i == j) {
                    strikeCount++;
                    continue;
                }
                if (target[i] == userInput[j] && i != j) {
                    ballCount++;
                }
            }
        }
        return new int[]{strikeCount, ballCount};
    }
}
