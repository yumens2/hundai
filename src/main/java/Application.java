import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int opt = 1;
            while (opt == 1) {
                // 난수 생성
                String answer = Computer.makeRandomNumber();
                System.out.println(answer);

                // 게임 실행
                Player.playBaseballGame(answer);

                // 게임 종료
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 옵션 입력 받기
                opt = getInputOption(sc);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static int getInputOption(Scanner sc) {
        String input = sc.nextLine();
        System.out.println(input);
        if ("1".equals(input) || "2".equals(input)) {
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 게임을 종료합니다.");
        }
    }
}