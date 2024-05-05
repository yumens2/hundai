import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    public List<String> input(){
        // 사용자의 입력을 받는 함수
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner s = new Scanner(System.in);

        String input = s.next();

        String[] numbers = input.split("");
        if (!isValidInput(numbers)) {
            throw new IllegalArgumentException("잘못된 수 입니다");
        }
        else {
            List<String> userNumber = new ArrayList<>();

            for (String number : numbers) {
                userNumber.add(number);
            }
            return userNumber;
        }
    }

    boolean isValidInput(String[] number){
        if (number.length != 3){
            return false;
        }

        HashSet<String> uniqueNumbers = new HashSet<>();
        for (String numbers : number) {
            if (!uniqueNumbers.add(numbers)) {
                // 중복된 숫자가 있으면 false 반환
                return false;
            }
        }
        return true;

    }
}
