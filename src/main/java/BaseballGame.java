import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private static boolean continuePlaying = true;

    public static void main(String[] args) {
        while (continuePlaying) {
            BaseballGame game = new BaseballGame();
            boolean won = game.playGame();
            if (won) {
                continuePlaying = Input.askForRestart();
            }
        }
    }

    private boolean playGame() {
        computerNumbers = RandomNumberGenerator.generateNumbers();
        while (true) {
            Output.printMessage("3개의 서로 다른 숫자를 입력해주세요(1~9): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            List<Integer> userNumbers = Input.getInputFromUser(input);
            if (userNumbers.get(0) == -1){
                continuePlaying = Input.askForRestart();
                return false;
            }
            int[] score = ScoreCalculator.calculateScore(userNumbers, computerNumbers);
            int strikes = score[0];
            int balls = score[1];

            String re = Output.printResult(strikes, balls);
            Output.printlnMessage(re);
            if (strikes == 3) {
                Output.printlnMessage("승리!");
                return true;
            }
        }
    }

}