import java.util.HashSet;
import java.util.Scanner;

public class InputException {

    private InputException() {

    }

    public static String inputUserNum() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String result;
        result = sc.nextLine();
        if (result.length() > 3 || result.length() == 0) {
            throw new IllegalArgumentException("중복없이 3자리 숫자를 입력해주세요.");
        }
        if (!InputException.checkRedundant(result)) {
            throw new IllegalArgumentException("중복없이 3자리 숫자를 입력해주세요.");
        }
        if (!InputException.checkInt(result)) {
            throw new IllegalArgumentException("중복없이 3자리 숫자를 입력해주세요.");
        }
        return result;
    }

    public static int inputChoice() throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        int result;

        result = sc.nextInt();
        if (result != 1 && result != 2) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
        }
        return result;
    }

    public static boolean checkRedundant(String str) {
        boolean result = true;
        char[] arr = str.toCharArray();
        HashSet<Integer> set = new HashSet<>();

        for (char c : arr) {
            if (!set.contains(c - '0')) {
                set.add(c - '0');
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkInt(String str) {
        return str.matches("[1-9]+");
    }
}
