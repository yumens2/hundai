import java.util.Scanner;

public class GameAgain { //게임을 또 할지 여쭤보고 그 결과를 알려주는 함수
    public boolean gameAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();

        if(input == 1)
            return true;
        else
            return false;
    }
}
