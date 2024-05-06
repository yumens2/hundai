import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    public List<Integer> getNum(){
        System.out.println("숫자를 입력해 주세요 : ");
        Scanner sc= new Scanner(System.in);
        try {
            String inputInt = sc.nextLine();

            if (inputInt.length() !=3){
                throw new IllegalArgumentException();
            }

            return makeListInt(inputInt);

        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> makeListInt(String inputInt){
        List<Integer> inputIntList = new ArrayList<>();

        for(int i = 0; i<3;i++){
            int a = inputInt.charAt(i);
            if (checkRange(a)) {
                inputIntList.add(a);
            }
        }
        return inputIntList;
    }

    public boolean checkRange(int i){
        if ((i >=0) & (i <9)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
