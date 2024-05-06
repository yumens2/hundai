import java.util.List;
import java.util.Scanner;

public class Player {
    public String getNum(){
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner sc= new Scanner(System.in);
        try {
            String inputInt = sc.nextLine();

            if (inputInt.length() !=3){
                throw new IllegalArgumentException();
            }

            int a = inputInt.charAt(0);
            int b = inputInt.charAt(1);
            int c = inputInt.charAt(2);



            return inputInt;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

}
