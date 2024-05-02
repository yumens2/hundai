import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    public void inputplayernum() throws IllegalArgumentException{
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        try{
            num = sc.nextInt();
        }catch (InputMismatchException e){
            throw new IllegalArgumentException("잘못 입력했습니다. 정수만 입력 가능합니다.");
        }
        if((num >= 100) && (num <= 999)){
            System.out.println(" num = " +num);
        }
        else{
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
    }
}
