import java.util.Scanner;

public class Player {
    public void inputplayernum(){
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        num = sc.nextInt();
        System.out.println(" num = " +num);
    }
}
