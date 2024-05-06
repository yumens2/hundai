import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public static List<Integer> getInput() throws IllegalArgumentException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("1~9까지의 숫자를 중복없이 입력해주세요.");
        List<Integer> userInputs = new ArrayList<>();
        for(int i = 0; i<3; i++) {
            System.out.println(i + 1 + "번째 숫자를 입력해주세요 : ");
            Integer num = scanner.nextInt();
            if (isValid(userInputs,num)){
                userInputs.add(num);
            }
            else{
                System.out.println("잘못된 숫자입니다.");
                throw new IllegalArgumentException();
            }
        }
        return userInputs;
    }

    private static boolean isValid(List<Integer> nums,Integer num){
        return num > 0 && num < 10 && !nums.contains(num);
    }
}
