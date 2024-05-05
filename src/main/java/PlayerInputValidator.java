import java.util.Scanner;

public class PlayerInputValidator {
    public static boolean validateInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine().trim();

        if(userInput.equals("1")) {
            return true;
        }else if(userInput.equals("2")) {
            return false;
        }else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
