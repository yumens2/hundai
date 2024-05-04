
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    public ArrayList<Integer> input(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> userInput = new ArrayList<Integer>();

        System.out.print("숫자를 입력해 주세요 : ");
        String userString = scan.nextLine();

        check(userString);
        for (int i = 0; i < userString.length(); i++){
            int number = Character.getNumericValue(userString.charAt(i));
            userInput.add(number);
        }
        return userInput;
    }
    public void check(String user){
        if(user.length() != 3){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for(int i=0; i<3; i++){
            if(!Character.isDigit(user.charAt(i))){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if(user.indexOf(user.charAt(i)) != i){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
    public boolean restart(){
        Scanner scan = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int flag = scan.nextInt();
        if (flag == 1){
            return true;
        }
        else if(flag == 2){
            return false;
        }
        else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
