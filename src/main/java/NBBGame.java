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
}