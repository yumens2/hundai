import java.util.Scanner;

public class GameManager {

    public void decideRestart() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        if (input == 1 || input == 2) {
            if (input == 1) {
                new Game().run();
            }
        } else {
            throw new IllegalArgumentException("숫자 1또는 2를 입력해야 합니다.");
        }
    }
}
