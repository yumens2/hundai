import java.util.Scanner;

public class NBBGame {
    private final GameNumber answer;
    private final Scanner scanner;

    private static final String HELP_MSG = "숫자를 입력해 주세요 : ";
    private static final String SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    NBBGame(Scanner scanner) {
        this.answer = new GameNumber();
        this.scanner = scanner;
    }

    public void playGame() {
        while (true) {
            System.out.print(HELP_MSG);
            GameNumber userGuess = getUserGuess();

            SBCount result = userGuess.compareTo(answer);
            System.out.println(result);

            if (result.isAllStrike()) {
                System.out.println(SUCCESS_MSG);
                break;
            }
        }
    }

    private GameNumber getUserGuess() {
        String input = scanner.nextLine();

        return new GameNumber(input);
    }
}