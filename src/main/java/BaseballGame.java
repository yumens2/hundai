import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.*;

public class BaseballGame {
    public void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            playGame();
            playAgain = askToPlayAgain();
        }
        System.out.println("게임 종료");
    }


    private void playGame() {
        int[] computerNumbers = generateComputerNumbers();
        int attempts = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int[] userNumbers = getUserNumbers();
            int[] result = calculateResult(computerNumbers, userNumbers);

            printResult(result);

            if (result[0] == 3) {
                System.out.println("승리! " + (attempts + 1) + "번 만에 정답을 맞췄습니다.");
                break;
            }

            attempts++;
        }
    }


    private int[] generateComputerNumbers() {
        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1; // 1부터 9 사이의 난수 생성
            numbers.add(randomNumber);
        }

        int[] result = new int[3];
        int i = 0;

        for (int number : numbers) {
            result[i] = number;
            i++;
        }
        return result;
    }


    private int[] getUserNumbers() {
        int[] userNumbers = new int[3];

        while (true) {
            try {
                String userInput = readUserInput();
                userNumbers = parseUserInput(userInput);
                return userNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e; // 예외를 다시 던져서 상위 호출자로 전달
                // System.exit(0);
            }
        }
    }


    private String readUserInput() {
        System.out.print("세 자리 숫자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private int[] parseUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }

        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = userInput.charAt(i) - '0';
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력하세요.");
            }
        }
        return userNumbers;
    }


    private int[] calculateResult(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            } else if (containsNumber(computerNumbers[i], userNumbers)) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }


    private boolean containsNumber(int number, int[] numbers) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }



}
