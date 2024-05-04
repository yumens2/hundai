import java.util.ArrayList;
import java.util.Scanner;

public class input {
    public ArrayList<Integer> inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

        isValidate(input);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return numbers;
    }

    public void isValidate(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리 숫자를 입력해주세요!");
        }

        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요!");
        }

        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요!");
        }
    }
}
