import java.util.Scanner;

public class IO {

    private Scanner scanner = new Scanner(System.in);

    public String Input() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public boolean Regame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String ans = scanner.nextLine();
        return ans.equals("1");
    }

}
