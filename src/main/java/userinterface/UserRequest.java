package userinterface;

import java.util.Scanner;

public class UserRequest {

    private final Scanner scanner;
    private final InputValidator inputValidator;

    public UserRequest() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public String getUserGuess() {
        String input = scanner.nextLine();

        inputValidator.validateGuess(input);

        return input;
    }

    public String getUserReplay() {
        String input = scanner.nextLine();

        inputValidator.validateReplay(input);

        return input;
    }

    public void closeScanner() {
        scanner.close();
    }
}
