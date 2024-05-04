import java.util.Scanner;

public class Application {
    private boolean wantRestart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");

        String input = scanner.nextLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

    }
}
