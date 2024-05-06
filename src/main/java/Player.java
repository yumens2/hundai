import java.util.List;
import java.util.Scanner;

public class Player {
    public int getNum(){
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner sc= new Scanner(System.in);
        try {
            int inputInt = sc.nextInt();
            int length = (int)(Math.log10(inputInt)+1);
            if (length !=3){
                throw new IllegalArgumentException();
            }
            return inputInt;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

}
