import java.util.Scanner;

public class Application {
    private static final String RESTART = "1";
    private static final String QUIT = "2";

    private static final String RESTART_MSG =
            String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요. ", RESTART, QUIT);

    private static boolean wantRestart(Scanner scanner) {
        System.out.println(RESTART_MSG);

        String input = scanner.nextLine();
        if (input.equals(RESTART)) {
            return true;
        } else if (input.equals(QUIT)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            NBBGame game = new NBBGame(scanner);

            game.playGame();
        } while (wantRestart(scanner));
    }
}
