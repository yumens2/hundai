import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getInputFromUser() {
        while (true) {
            try {
                System.out.print("Enter three unique numbers from 1 to 9: ");
                String input = scanner.nextLine();
                List<Integer> numbers = parseInput(input);
                validateNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("You must enter exactly three digits.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            int num = Character.digit(ch, 10);
            if (num == -1) {
                throw new IllegalArgumentException("Only numeric inputs are allowed.");
            }
            numbers.add(num);
        }
        return numbers;
    }

    private static void validateNumbers(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("Numbers must be between 1 and 9.");
            }
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("All numbers must be unique.");
        }
    }

    public static boolean askForRestart() {
        Output.printMessage("Press 1 to restart, 2 to exit:");
        String input = scanner.nextLine();
        return "1".equals(input);
    }
}