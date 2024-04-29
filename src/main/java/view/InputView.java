package view;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public String getPlayerAnswer() {
        OutputView.printWithNoEnter(PLAYER_INPUT_NUMBER_MESSAGE);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
