import java.util.Scanner;

public class GameAgain  {
    public boolean gameAgain() throws IllegalArgumentException{ //게임을 또 할지 여쭤보고 그 결과를 알려주는 함수
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input;
        Scanner scan = new Scanner(System.in);

        try { //사용자의 입력이 올바르지 않으면 IllegalArgumentException 던짐
            input = scan.nextInt();
        }catch(Exception e){
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
        }

        switch (input){
            case 1 :
                return true;
            case 2:
                return false;
            default: //1과 2이외의 값이 입력되는 경우 예외 던짐
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
        }
    }
}
