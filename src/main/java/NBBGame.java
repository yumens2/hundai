import java.util.Scanner;

public class NBBGame {
    private final GameNumber answer;

    NBBGame() {
        this.answer = new GameNumber();
    }

    private static GameNumber getUserGuess() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        return new GameNumber(input);
    }

    public void playGame() {
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            GameNumber userGuess = getUserGuess();

            SBCount result = userGuess.compareTo(answer);
            System.out.println(result);

            if (result.isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}