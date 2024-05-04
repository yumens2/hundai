import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static randomNumber randomNumberGenerator = new randomNumber();
    private static BaseballGame baseballGame = new BaseballGame();
    private static input input = new input();

    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            startGame();
            isContinue = isContinueGame();
        }
    }

    public static void startGame() {
        ArrayList<Integer> targetNumbers = randomNumberGenerator.generateRandomNumbers();

        while(true) {
            ArrayList<Integer> inputNumbers = input.inputNumbers();
            int result_of_the_game = baseballGame.play(targetNumbers, inputNumbers);

            if (result_of_the_game == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static boolean isContinueGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();

        if (input == 1) {
            return true;
        } else {
            return false;
        }
    }
}
