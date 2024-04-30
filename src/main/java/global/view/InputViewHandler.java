package global.view;


import java.util.Scanner;

public class InputViewHandler {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String INPUT_GAME_NUMBER_MESSAGE = "게임 번호를 입력해주세요 : ";

    public static String printInputGameNumber() {
        System.out.println(INPUT_GAME_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
