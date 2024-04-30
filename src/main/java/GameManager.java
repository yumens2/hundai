import domain.Computer;
import view.Input;
import view.InputImpl;

import java.util.List;

public class GameManager {
    private static final String OUT = "3스트라이크";
    private boolean isOut;

    public GameManager() {}

    public void batting(Computer computer, List<Integer> randomBalls) {
        Input input = new InputImpl();
        while (!isOut) {
            String userInput = input.baseballInput();
            String answer = computer.checkStrike(randomBalls, userInput);
            System.out.println(answer);
            setIsOut(answer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    private void setIsOut(String input) {
        if (input.equals(OUT)) {
            isOut = true;
        }
    }
}
