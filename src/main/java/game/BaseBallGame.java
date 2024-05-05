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
            Hint hint = getHintFromComputer(playerNumbers);
            printHint(hint);
            if(checkGameOver(hint)) {
                gameOver();
            }
        }
    }

    private void initComputer() {
        computer = new Computer();
    }

    private List<Integer> inputPlayerNumber() {
        return Casting.stringToIntegerList(inputView.inputPlayerNumber());
    }

    private Hint getHintFromComputer(List<Integer> playerNumbers) {
        return computer.getHint(playerNumbers);
    }

    private void printHint(Hint hint) {
        outputView.printHint(hint);
    }

    private boolean checkGameOver(Hint hint) {
        return hint.is3Strike();
    }

    private GameMenu inputGameMenu() {
        String gameMenu = inputView.inputGameMenu();
        return GameMenu.findByCode(Integer.parseInt(gameMenu));
    }

    private void gameOver() {
        outputView.printEndMessage();
        GameMenu gameMenu = inputGameMenu();
    }
}