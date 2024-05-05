package view;

import game.Hint;

public class OutputView {
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void printHint(Hint hint) {
        System.out.println(hint);
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
}