package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputView {

    public static final int DIGIT = 3;
    public static final int FLAG_DIGIT = 1;
    public static final int FLAG_YES = 1;
    public static final int FLAG_NO = 2;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Integer> readNumbers() throws IOException {
        String readLine = br.readLine();
        checkInputLength(readLine, DIGIT);

        return parseNumbers(readLine);
    }

    public static boolean readWantGameRestart() throws IOException {
        String readLine = br.readLine();
        checkInputLength(readLine, FLAG_DIGIT);

        int number = parseInteger(readLine);
        validateFlagNumber(number);

        return number == FLAG_YES;
    }

    private static ArrayList<Integer> parseNumbers(String readLine) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < DIGIT; i++) {
            int number = readLine.charAt(i) - '0';
            validateNumber(number);
            numbers.add(number);
        }
        return numbers;
    }

    private static void validateNumber(int number) {
        if (!(number >= START_NUMBER && number <= END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateFlagNumber(int number) {
        if (!(number == FLAG_YES || number == FLAG_NO)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }
    }
}
