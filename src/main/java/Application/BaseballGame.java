package Application;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(java.lang.System.in);
        int opt = 1;

        while(opt == 1){
            // 난수 생성
            String answer = Computer.makeRandomNumber();
            java.lang.System.out.println(answer);

            // 게임 실행
            Player.playBaseballGame(answer);

            // 게임 종료
            java.lang.System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            java.lang.System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 옵션 입력 받기
            opt = Integer.parseInt(sc.nextLine());
        }
    }
}
