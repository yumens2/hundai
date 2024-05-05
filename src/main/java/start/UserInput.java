package start;

import java.util.Scanner;

public class UserInput {
    public static String getUserInput() {
        Scanner input = new Scanner(System.in);

        System.out.print("숫자를 입력해 주세요 : ");
        String s = input.nextLine();

        return s;
    }

    public static int getUser_int_Input() {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        return n;
    }
}
