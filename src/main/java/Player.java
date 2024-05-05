
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    ArrayList<Integer> userInput = new ArrayList<>();
    public ArrayList<Integer> input(){
        Scanner scan = new Scanner(System.in);
        userInput.clear();
        
        System.out.print("숫자를 입력해 주세요 : ");
        String userString = scan.nextLine();

        inputCheck(userString);
        for (int i = 0; i < userString.length(); i++){
            int number = Character.getNumericValue(userString.charAt(i));
            userInput.add(number);
        }

        return userInput;
    }
    public void inputCheck(String userString){
        if(userString.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
        for(int i=0; i<3; i++){
            char ch = userString.charAt(i);

            if(!Character.isDigit(ch)){
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
            if(Character.getNumericValue(ch)<1 || Character.getNumericValue(ch) > 9){
                throw new IllegalArgumentException("1~9사이의 숫자를 입력해주세요");
            }
            if(userString.indexOf(ch) != i){
                throw new IllegalArgumentException("중복된 값 입니다.");
            }
        }
    }
    public boolean restart(){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            int flag = scan.nextInt();
            scan.nextLine();

            if (flag == 1){
                return true;
            }
            else if(flag == 2){
                return false;
            }
            else{
                throw new IllegalArgumentException("1또는 2를 입력해주세요");
            }
        }catch (InputMismatchException e){
            throw new IllegalArgumentException("1또는 2를 입력해주세요");
        }
    }
}
