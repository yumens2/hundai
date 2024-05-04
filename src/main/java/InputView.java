import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final int NUMBER_LENGTH = 3;
    private static final int STATE_LENGTH = 1;
    private static final int STATE_RESTART = 1;
    private static final int STATE_QUIT = 2;

    private static final int MIN = 1;
    private static final int MAX = 9;

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<Integer> readNumber() throws IOException {
        String line = br.readLine();
        checkNumberLength(line);
        return makeNumberList(line);
    }

    public static int readState() throws IOException {
        String line = br.readLine();
        checkStateLength(line);

        char ch = line.charAt(0);
        validateNumber(ch);

        int number = line.charAt(0) - '0';
        validateState(number);

        return number;
    }

    public static List<Integer> makeNumberList(String line) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char ch = line.charAt(i);
            validateNumber(ch);
            int number = line.charAt(i) - '0';
            validateRange(number);
            numberList.add(number);
        }
        return numberList;
    }

    private static void checkNumberLength(String line) {
        if (line.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkStateLength(String line) {
        if (line.length() != STATE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumber(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateState(int number) {
        if (number != STATE_RESTART && number != STATE_QUIT) {
            throw new IllegalArgumentException();
        }
    }
}
