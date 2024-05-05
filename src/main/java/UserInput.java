import java.util.Scanner;

public class UserInput {
    public static int userInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Exception.checkDuplicate(num);
        Exception.checkLength(num);
        Exception.checkZero(num);
        return num;
    }
}
