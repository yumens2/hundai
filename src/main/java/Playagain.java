import java.util.Scanner;

public class Playagain {
    public boolean playagain(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        if(answer == '1'){
            return true;
        }
        return false;
    }
}