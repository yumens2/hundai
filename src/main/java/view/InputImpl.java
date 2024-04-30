package view;

import java.util.Scanner;

public class InputImpl implements Input{


    @Override
    public String baseballInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
