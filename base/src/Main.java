import java.util.Random;
import java.util.Scanner;

public class Main{
    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int[] computerNumbers = generateComputerNumbers();

            int[] userNumbers;
            try {
                userNumbers = getUserNumbers(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("게임을 종료합니다.");
                scanner.close();
                return;
            }

            while (!checkMatch(computerNumbers, userNumbers)) {
                try {
                    userNumbers = getUserNumbers(scanner);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("게임을 종료합니다.");
                    scanner.close();
                    return;
                }
            }

            System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = scanner.nextInt();
            if (choice != 1) {
                break;
            }
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }

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
    }

    private static boolean checkMatch(int[] computerNumbers, int[] userNumbers) {
        int strike = 0;
        int ball = 0;
        boolean match = false;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            for (int j = 0; j < DIGIT_COUNT; j++) {
                if (userNumbers[i] == computerNumbers[j]) {
                    match = true;
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        if (!match) {
            System.out.println("낫싱");
        } else if (strike == DIGIT_COUNT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }
}
