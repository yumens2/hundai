import java.util.Scanner;
import java.util.Set;

import static constant.MessageConstants.*;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserGuess() {
        System.out.print(GUESS_MESSAGE);

        String input = scanner.nextLine();

        validateGuess(input);

        return input;
    }

    public boolean isReplay() {
        System.out.println(REPLAY_MESSAGE);
        String input = scanner.nextLine();

        validateReplay(input);

        return input.equals("1");
    }

    private void validateGuess(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException(GUESS_ERROR_MESSAGE);
        }
        try {
            Set<Character> inputSet = Set.of(input.charAt(0), input.charAt(1), input.charAt(2));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(GUESS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private void validateReplay(String input) {
        if (!input.matches("[1-2]")) {
            throw new IllegalArgumentException(REPLAY_ERROR_MESSAGE);
        }
    }
}
