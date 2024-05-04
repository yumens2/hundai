package game;

import java.util.List;
import util.Casting;
import view.InputView;
import view.OutputView;

public class BaseBallGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Computer computer;

    public void gameStart() {
        initComputer();
        while(true) {
            List<Integer> playerNumbers = inputPlayerNumber();
            Hint hint = computer.getHint(playerNumbers);
            outputView.printHint(hint);
        }
    }

    private void initComputer() {
        computer = new Computer();
    }

    private List<Integer> inputPlayerNumber() {
        return Casting.stringToIntegerList(inputView.inputPlayerNumber());
    }
}