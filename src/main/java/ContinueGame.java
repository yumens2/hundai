import java.util.InputMismatchException;
import java.util.Scanner;

public class ContinueGame {
    public int continueorexit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e){
            throw new IllegalArgumentException("잘못 입력했습니다. 1 또는 2만 입력 가능합니다.");
        }
        if(!((num == 1)||(num == 2))){
            throw new IllegalArgumentException("잘못 입력했습니다. 1 또는 2만 입력 가능합니다.");
        }
        return num;
    }
}
