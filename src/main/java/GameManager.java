import domain.Computer;
import domain.ComputerImpl;
import view.Input;
import view.InputImpl;

import java.util.List;

public class GameManager {
    private static final String OUT = "3스트라이크";
    private boolean isEnd;
    private boolean isOut;

    public GameManager() {}

    public void playBall() {
        Computer computer = new ComputerImpl();
        Input input = new InputImpl();

        while (!isEnd) {
            List<Integer> randomBalls = computer.generateRandomNumbers();
            batting(computer, randomBalls);
            setIsNotOut();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int userInput = input.endInput();
            setIsEnd(userInput);
        }
    }

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

    private void setIsEnd(int input) {
        if (input == 2) {
            isEnd = true;
        }
    }

    private void setIsOut(String input) {
        if (input.equals(OUT)) {
            isOut = true;
        }
    }

    private void setIsNotOut() {
        isOut = false;
    }
}
