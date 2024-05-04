package UserInput;

import java.util.Scanner;

public class RestartInput {

    private static final Scanner scanner = new Scanner(System.in);

    // 사용자의 입력이 1 또는 2가 아닌 경우 예외 발생
    public static int restartInput() {
        String inputString = scanner.nextLine();
        if (!validationRestartInput(inputString)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    // 사용자의 입력이 1 또는 2가 아닌 경우 false, 1 또는 2인 경우 true 리턴
    private static boolean validationRestartInput(String inputString) {
        return inputString.charAt(0) == '1' || inputString.charAt(0) == '2';
    }
}