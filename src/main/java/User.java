import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public static void isValidInputNum(String input) throws IllegalArgumentException {

        if((input.length() !=3) ||
                (input.charAt(0)==input.charAt(1) || input.charAt(0)==input.charAt(2)||input.charAt(1)==input.charAt(2))
                ||(input.contains("0"))){
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        for(String num : input.split("")){
            if(!Character.isDigit(num.charAt(0))){
                throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
            }
        }

    }
    public static List<Integer> createInputNum(){
        String inputnum;
        List<Integer> userInput = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        inputnum = sc.nextLine();
        isValidInputNum(inputnum);
        for(String num: inputnum.split("")){
            userInput.add(Integer.parseInt(num));
        }
        return userInput;

    }
}