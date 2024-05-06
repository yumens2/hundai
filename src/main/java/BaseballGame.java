import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3; // 게임에서 사용되는 숫자의 길이
    private static final int MIN_NUMBER = 1; // 생성될 숫자의 최소값
    private static final int MAX_NUMBER = 9; // 생성될 숫자의 최대값

    int[] computerNumbers; // 컴퓨터가 생성한 숫자를 저장하는 배열

    // 생성자: BaseballGame 객체를 생성하면 컴퓨터가 랜덤한 숫자를 생성함
    public BaseballGame() {
        this.computerNumbers = generateRandomNumbers();
    }

    // 랜덤한 숫자를 생성하여 배열로 반환하는 메서드
    public int[] generateRandomNumbers() {
        Set<Integer> uniqueNumbers = generateUniqueNumbers();
        return convertSetToArray(uniqueNumbers);
    }

    // 중복되지 않는 랜덤한 숫자를 생성하여 Set으로 반환하는 메서드
    private Set<Integer> generateUniqueNumbers() {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers;
    }

    // Set을 배열로 변환하여 반환하는 메서드
    private int[] convertSetToArray(Set<Integer> uniqueNumbers) {
        int[] numbers = new int[NUMBER_LENGTH];
        int index = 0;
        for (int num : uniqueNumbers) {
            numbers[index++] = num;
        }

        return numbers;
    }

    // 사용자가 입력한 문자열을 숫자 배열로 변환하는 메서드
    public int[] convertToIntArray(String input) {
        int[] numbers = new int[NUMBER_LENGTH];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }

    // 스트라이크 개수를 반환하는 메서드
    public int countStrikes(int[] guessNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isStrike(guessNumbers, i)) {
                count++;
            }
        }
        return count;
    }

    // 해당 인덱스의 숫자가 스트라이크인지 확인하는 메서드
    private boolean isStrike(int[] guessNumbers, int index) {
        return guessNumbers[index] == computerNumbers[index];
    }

    // 볼 개수를 반환하는 메서드
    public int countBalls(int[] guessNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (isBall(guessNumbers, i)) {
                count++;
            }
        }
        return count;
    }

    // 해당 인덱스의 숫자가 볼인지 확인하는 메서드
    private boolean isBall(int[] guessNumbers, int index) {
        return guessNumbers[index] != computerNumbers[index] && contains(computerNumbers, guessNumbers[index]);
    }

    // 배열에 특정 숫자가 포함되어 있는지 확인하는 메서드
    private boolean contains(int[] array, int number) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    // 힌트를 출력하는 메서드
    public void displayHint(int strikes, int balls) {
        if (strikes > 0 && balls > 0) {
            System.out.println(strikes + "볼 " + balls + "스트라이크");
        } else if (strikes > 0) {
            System.out.println(strikes + "스트라이크");
        } else if (balls > 0) {
            System.out.println(balls + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    // 게임을 시작하는 메서드
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameEnded = false;

        while (!isGameEnded) {
            try {
                String input = getUserInput(scanner);
                isGameEnded = processUserGuess(input, scanner);
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
                System.exit(0);
            }
        }
    }


    // 사용자 입력을 받는 메서드
    private String getUserInput(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요: ");
        return scanner.nextLine();
    }

    // 사용자의 추측을 처리하고 게임이 종료되었는지 여부를 반환하는 메서드
    private boolean processUserGuess(String input, Scanner scanner) {
        validateInput(input);

        int[] guessNumbers = convertToIntArray(input);
        int strikes = countStrikes(guessNumbers);
        int balls = countBalls(guessNumbers);

        if (strikes == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return askToRestartGame(scanner);
        } else {
            displayHint(strikes, balls);
            return false;
        }
    }

    // 사용자 입력이 유효한지 확인하는 메서드
    private void validateInput(String input) {
        if (input.length() != NUMBER_LENGTH || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    // 게임을 재시작할지 묻고 그에 따라 게임을 처리하는 메서드
    private boolean askToRestartGame(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = scanner.nextLine();
        if ("1".equals(restart)) {
            this.computerNumbers = generateRandomNumbers();
            return false;
        } else if ("2".equals(restart)) {
            return true;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }


    // 메인 메서드: 게임을 시작하는 지점
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.startGame();
    }
}