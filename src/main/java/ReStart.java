import java.util.Scanner;

public class ReStart {

    public boolean selectContinue() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
        String input = sc.nextLine().trim();
        validation.validateInt(input);
        return input.equals("1");
    }
}
