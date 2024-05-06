import java.util.Scanner;

public class GameManager {
    public boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int restart = scanner.nextInt();
        if (restart == 1){
            return true;
        }
        else if (restart == 2){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
