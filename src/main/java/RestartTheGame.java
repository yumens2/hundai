import java.util.Scanner;

public class RestartTheGame {
    public boolean regame(){
        Scanner s = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int exit = s.nextInt();

        if (exit == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
