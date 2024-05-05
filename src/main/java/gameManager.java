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

    private boolean gameMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int option = scanner.nextInt();

        if (!(option == 1 || option == 2)) {
            throw new IllegalArgumentException("1 혹은 2를 입력해야 합니다.");
        } else if (option == 1) {
            return true;
        }
        return false;
    }

    private boolean computBallCount(int[] randNum, int[] userNum) {
        int strikes = countStrikes(randNum, userNum);
        int balls = countBalls(randNum, userNum);

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 0) {
            System.out.printf("%d볼\n", balls);
        } else if (balls == 0) {
            System.out.printf("%d스트라이크\n", strikes);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        }
        return false;
    }

    private int countBalls(int[] randNum, int[] userNum) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && randNum[i] == userNum[j]) {
                    balls++;
                }
            }
        }
        return balls;
    }

    private int countStrikes(int[] randNum, int[] userNum) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (randNum[i] == userNum[i]) {
                strikes++;
            }
        }
        return strikes;
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

    private boolean isValidDigits(int[] numDigits) {
        for (int i = 0; i < 3; i++) {
            if (numDigits[i] < 1 || numDigits[i] > 9) {
                return false;
            }
        }
        return true;
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
