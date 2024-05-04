package UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestartInput {

    // 사용자의 입력이 1 또는 2가 아닌 경우 예외 발생
    public static int restartInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
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