package BaseballGame;

import java.util.List;
import java.util.Scanner;

public class InputManager {
    private Scanner scanner = new Scanner(System.in);

    public List<String> getValidInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        return List.of(input.split(""));
    }

    public void closeScanner() {
        scanner.close();
    }
}