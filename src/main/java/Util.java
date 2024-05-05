import java.util.Scanner;

public class Util {
    public int getInput() {
        System.out.println("숫자를 입력해 주세요");
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        return input;
    }
}
