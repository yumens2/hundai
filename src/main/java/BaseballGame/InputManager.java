package BaseballGame;

import java.util.*;

public class InputManager {
    private Scanner scanner = new Scanner(System.in);

    public List<String> getValidInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        return List.of(input.split(""));
    }

    public int getUserChoice() {
        String userChoice = scanner.nextLine();
        if (Objects.equals(userChoice, "1") || Objects.equals(userChoice, "2")) {
            return Integer.parseInt(userChoice);
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private boolean isValidInput(String input) {
        if (!input.matches("[1-9]{3}")) {
            return false;
        }
        Set<Character> uniqueDigits = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueDigits.add(c);
        }
        return uniqueDigits.size() == 3;
    }

    public void closeScanner() {
        scanner.close();
    }
}