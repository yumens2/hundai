import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public ArrayList<Integer> getUserNumber() {
        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();

        System.out.print("숫자를 입력해 주세요 : ");
        String input = sc.nextLine().trim();
        validation.validateNumber(input);
        ArrayList<Integer> parsed = new ArrayList<>();

        for (int i = 0; i < Constant.NUM; i++) {
            parsed.add(input.charAt(i) - '0');
        }

        return parsed;
    }
}
