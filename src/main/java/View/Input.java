package View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Integer> numbers;
    public static List<Integer> getInputFromUser(String input) {
        while (true) {
            try {

                numbers = checkInput(input);
                validateNumbers(numbers);
                return numbers;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                numbers = new ArrayList<>(Arrays.asList(-1, 0, 0));
                return numbers;
            }
        }
    }

    public static List<Integer> checkInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            int num = Character.digit(ch, 10);
            if (num == -1) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }
            numbers.add(num);
        }
        return numbers;
    }

    public static void validateNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("숫자는 1~9사이여야 합니다.");
            }
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("숫자가 서로 달라야 합니다.");
        }
    }

    public static boolean askForRestart() {
        Output.printMessage("재시작을 원하면 1을, 종료를 원하면 2를 눌러주세요: ");
        String input = scanner.nextLine();
        return "1".equals(input);
    }

}