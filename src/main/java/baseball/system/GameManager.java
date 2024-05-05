package baseball.system;

import baseball.domain.BallCount;
import baseball.domain.BaseballNumber;
import baseball.domain.Computer;
import baseball.exception.constants.ErrorMessage;
import baseball.system.constants.Command;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {

    public static GameManager instance = new GameManager();
    private Computer computer;
    boolean isRunning; //게임이 실행 되고 있는가
    private Scanner scanner = new Scanner(System.in);

    private GameManager() {
    }

    public static GameManager getInstance() {
        return instance;
    }

    public void startGame() {
        isRunning = true;
        computer = new Computer();
        while (isRunning) {
            //입력받는다
            BaseballNumber userBaseballNumber = inputBaseballNumber();
            //정답과 비교한다
            BallCount result = computer.calculateBallCount(userBaseballNumber);
            //결과를 출력한다
            OutputView.resultMessage(result);
            //맞췄다면 재시도할지 물어본다
            if (result.isOut()) {
                isRunning = askTryAgain();
            }
        }
    }

    private boolean askTryAgain() {
        InputView.restartMessage();
        String input = scanner.next();

        if (input.equals(Command.RESTART)) {
            computer.initBaseballNumber();
            return true;
        } else if (input.equals(Command.EXIT)) {
            return false;
        } else {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TRY_AGAIN.getDescription());
        }
    }

    private BaseballNumber inputBaseballNumber() {
        InputView.inputBaseballNumberMessage();
        String input = scanner.next();

        return convertToBaseballNumber(input);
    }

    private BaseballNumber convertToBaseballNumber(String input) {
        char[] inputChar = input.toCharArray();
        List<Integer> numbers = new ArrayList<>();

        for (char c : inputChar) {
            numbers.add(Integer.valueOf(c - '0'));
        }
        return new BaseballNumber(numbers);
    }

}
