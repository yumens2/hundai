package src.io;

import static src.util.Validator.validateGuessNumber;
import static src.util.Validator.validateOptionNumber;

import java.io.InputStream;
import java.util.Scanner;
import src.game.GameState;

public class Input {

    private final Scanner scanner;

    public Input(InputStream stream) {
        this.scanner = new Scanner(stream);
    }

    public int getGuessNumberFromUser() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInputStr = scanner.nextLine();
        return validateGuessNumber(userInputStr);
    }

    public GameState getGameStateFromUser() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInputStr = scanner.nextLine();
        return validateOptionNumber(userInputStr);
    }
}
