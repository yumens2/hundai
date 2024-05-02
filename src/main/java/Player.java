import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    public void inputplayernum() throws IllegalArgumentException{
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        num = sc.nextInt();
        if((num >= 100) && (num <= 999)){
            System.out.println(" num = " +num);
        }
        else{
            throw new IllegalArgumentException("유효하지 않은 입력이 발생했습니다.");
        }
    }
}
