package baseball;

import java.util.Scanner;

public class User {
    private int guessNum;
    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setGuessNum() {
        this.guessNum = scanner.nextInt();
    }

    public int getGuessNum() {
        return guessNum;
    }

    public int makeGuess() {
        this.guessNum = scanner.nextInt();
        return guessNum;
    }
}
