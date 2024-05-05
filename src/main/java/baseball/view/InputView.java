package baseball.view;

import baseball.view.constants.GameMessage;

public class InputView {

    private InputView() {
    }

    public static void inputBaseballNumberMessage() {
        System.out.print(GameMessage.INPUT.getDescription());
    }

    public static void exitMessage() {
        System.out.println(GameMessage.EXIT.getDescription());
    }

    public static void restartMessage() {
        System.out.println(GameMessage.RESTART.getDescription());
    }
}
