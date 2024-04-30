package view;

import java.util.Scanner;

public class InputImpl implements Input{
    private static final String REGEX_END = "[12]{1}";
    private static final String REGEX_BASEBALL = "^[1-9]{3}$";

    @Override
    public String endInput() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validEndInput(input);
        return input;
    }

    @Override
    public String baseballInput() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        validBaseballInput(input);
        return input;
    }

    private void validEndInput(String input) {
        if (!input.matches(REGEX_END)) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private void validBaseballInput(String input) {
        if (!input.matches(REGEX_BASEBALL)) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

}
