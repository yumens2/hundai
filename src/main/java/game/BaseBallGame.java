package game;

import java.util.List;
import util.Casting;
import view.InputView;
import view.OutputView;

public class BaseballGame {
    private InputView inputView;
    private OutputView consoleOutputView;
    private Computer computer;

    private boolean exitFlag = false;

    public BaseballGame(InputView inputView, OutputView consoleOutputView, Computer computer) {
        this.inputView = inputView;
        this.consoleOutputView = consoleOutputView;
        this.computer = computer;
    }

    public void gameStart() {
        setComputerNumber();
        while(!exitFlag) {
            List<Integer> playerNumbers = inputPlayerNumber();
            Hint hint = getHintFromComputer(playerNumbers);
            printHint(hint);
            if(checkGameOver(hint)) {
                gameOver();
            }
        }
    }

    private void setComputerNumber() {
        computer.setNumbers();
    }

    private List<Integer> inputPlayerNumber() {
        return Casting.stringToIntegerList(inputView.inputPlayerNumber());
    }

    private Hint getHintFromComputer(List<Integer> playerNumbers) {
        return computer.getHint(playerNumbers);
    }

    private void printHint(Hint hint) {
        consoleOutputView.printHint(hint);
    }

    private boolean checkGameOver(Hint hint) {
        return hint.is3Strike();
    }

    private GameMenu inputGameMenu() {
        String gameMenu = inputView.inputGameMenu();
        return GameMenu.findByCode(Integer.parseInt(gameMenu));
    }

    private void gameOver() {
        consoleOutputView.printEndMessage();
        GameMenu gameMenu = inputGameMenu();
        if(gameMenu == GameMenu.RESTART) {
            setComputerNumber();
        } else if(gameMenu == GameMenu.EXIT) {
            exitFlag = true;
        }
    }
}