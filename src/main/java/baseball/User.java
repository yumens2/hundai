package baseball;

import java.util.Scanner;

public class User {
    private String guessNum;
    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }
    public String makeGuess() {
        this.guessNum = scanner.nextLine();
        return guessNum;
    }
}
