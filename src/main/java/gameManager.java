import java.util.Random;
import java.util.Scanner;

public class gameManager {

    private static final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        int[] randNum = generateRand();

        try {
            int[] userNum = getInput();

            while (!computBallCount(randNum, userNum)) {
                userNum = getInput();
            }

            if (gameMenu()) {
                startGame();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private int[] getInput() {
        System.out.println("숫자를 입력해 주세요 : ");
        String userInput = scanner.nextLine();

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력이 3자리 수가 아닙니다.");
        }

        int[] userDigits = new int[]{
            Character.getNumericValue(userInput.charAt(0)),
            Character.getNumericValue(userInput.charAt(1)),
            Character.getNumericValue(userInput.charAt(2))
        };

        if (!isUniqueDigits(userDigits)) {
            throw new IllegalArgumentException("각 자리 수는 서로 다른 수로 이루어져야 합니다.");
        }

        if (!isValidDigits(userDigits)) {
            throw new IllegalArgumentException("각 숫자는 1부터 9까지 정수이어야 합니다.");
        }

        return userDigits;
    }

    private boolean isUniqueDigits(int[] numDigits) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (numDigits[i] == numDigits[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] generateRand() {
        Random random = new Random();
        int[] generatedRandNum = new int[3];

        generatedRandNum[0] = random.nextInt(1, 10);
        generatedRandNum[1] = generatedRandNum[0];
        generatedRandNum[2] = generatedRandNum[0];
        while (generatedRandNum[1] == generatedRandNum[0]) {
            generatedRandNum[1] = random.nextInt(1, 10);
        }
        while (generatedRandNum[2] == generatedRandNum[0]
            || generatedRandNum[2] == generatedRandNum[1]) {
            generatedRandNum[2] = random.nextInt(1, 10);
        }

        return generatedRandNum;
    }
}
