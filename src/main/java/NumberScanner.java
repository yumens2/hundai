import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberScanner {

    public List<Integer> playerNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        final Scanner scanner = new Scanner(System.in);
        final String scan = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for (String number : scan.split("")) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }

    public int again() {
        final Scanner scanner = new Scanner(System.in);
        int again = scanner.nextInt();
        if (again != 1 && again != 2) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        return again;
    }
}
