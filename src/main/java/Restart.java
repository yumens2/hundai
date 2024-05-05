import java.util.Scanner;

public class Restart {
    private final Scanner inputs;

    public Restart() {
        inputs = new Scanner(System.in);
    }

    public boolean askForRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputs.nextLine();
        return "1".equals(input);
    }
}
