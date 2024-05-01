import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.Validation.isValidInputNum;

public class User {


    /**
     * 사용자에게 입력값을 받고 입력값 List 반환 메서드
     * @return
     */
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