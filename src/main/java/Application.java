import java.util.Scanner;
import java.util.Random;

public class Application {
    private static final int NUM_DIGITS = 3;
    private int[] computerNumbers = new int[NUM_DIGITS];
    private Scanner scanner = new Scanner(System.in);

    public void playGame() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            generateComputerNumbers();
            boolean gameWon = false;
            while (!gameWon) {
                System.out.print("숫자를 입력해 주세요 : ");
                String input = scanner.nextLine();
                try {
                    int[] userNumbers = parseInput(input);
                    gameWon = checkAndDisplayResult(userNumbers);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return ;
                }
            }
            continuePlaying = askForAnotherRound();
        }
        scanner.close();
        System.out.println("게임이 종료되었습니다.");
    }

    public void generateComputerNumbers() {
        Random random = new Random();
        for (int i = 0; i < NUM_DIGITS; i++) {
            computerNumbers[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (computerNumbers[i] == computerNumbers[j]) {
                    i--; // regenerate this number
                    break;
                }
            }
        }
    }
    public int[] parseInput(String input) throws IllegalArgumentException {
        if (input.length() != NUM_DIGITS) {
            throw new IllegalArgumentException("입력 값은 " + NUM_DIGITS + "자리 숫자여야 합니다.");
        }
        int[] numbers = new int[NUM_DIGITS];
        for (int i = 0; i < NUM_DIGITS; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("1부터 9까지의 서로 다른 수를 입력해야 합니다.");
            }
            numbers[i] = c - '0';
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    throw new IllegalArgumentException("중복된 숫자가 있습니다.");
                }
            }
        }
        return numbers;
    }



    public static void main(String[] args) {
        Application game = new Application();
        game.playGame();
    }
}
