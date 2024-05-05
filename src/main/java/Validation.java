import java.util.HashSet;
import java.util.stream.Collectors;

public class Validation {

    public static boolean isValidNum(String input) {
        try {
            HashSet<Character> set = input.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toCollection(HashSet::new));

            if (set.size() != 3 || set.contains('0')) {
                throw new IllegalArgumentException();
            }
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.");

            return false;
        }

        return true;
    }

    public static boolean isValidEnd(String input) {
        try {
            int temp = Integer.parseInt(input);

            if (temp != 1 && temp != 2) {
                throw new IllegalArgumentException();
            }
            if (temp == 2) {
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다.");

            return false;
        }

        return true;
    }
}
