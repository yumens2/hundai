package view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";

    private Scanner scanner = new Scanner(System.in);
    public String inputPlayerNumber() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}