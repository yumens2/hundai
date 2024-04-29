package baseball;

import java.util.Scanner;

public class User {
    private final Scanner scanner;
    private static final int DIGIT_COUNT = 3;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }
    public String makeGuess() {
        String guessNum = scanner.nextLine();
        validateNum(guessNum);
        return guessNum;
    }

    private void validateNum(String guessNum) {
        if (guessNum.length() != DIGIT_COUNT)
            throw new IllegalArgumentException();

        for (int i = 0; i < guessNum.length(); ++i) {
            char c = guessNum.charAt(i);
            if (c < '1' || c > '9')
                throw new IllegalArgumentException();
        }
    }
}
