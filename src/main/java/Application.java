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



    public static void main(String[] args) {
        Application game = new Application();
        game.playGame();
    }
}
