import java.util.Scanner;

public class Restart {
    private final Scanner scanner;

    public Restart() {
        scanner = new Scanner(System.in);
    }

    public boolean askForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        return "1".equals(input);
    }
}
