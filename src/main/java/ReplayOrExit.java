import java.util.Scanner;

public class ReplayOrExit {
    public static int replayOrExit() {
        // 게임 종료 후 재시작할지, 종료할지 확인
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력입니다. 1 혹은 2만 입력하세요.");
            }

            if (choice == 1 || choice == 2) {
                return choice;
            } else {
                System.out.println("잘못된 입력입니다. 1 혹은 2만 입력하세요.");
            }
        }
    }
}
