package baseball.controller;


import baseball.model.ComputerNumGenerator;
import baseball.model.UserNumGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballSystem {
    public static final String RESTART = "1";
    public static final String QUIT = "2";

    public void runGame(){
        do{
            startOneGameSet();
        } while (!exit());
    }

    private static void startOneGameSet() {
        int[] computerNums = new ComputerNumGenerator().NUMS;
        int[] userNums = new UserNumGenerator().NUMS;
        boolean gameClear;
        do {
            NumberCompare set = new NumberCompare(userNums, computerNums);
            new OutputView(set).printGameResult();
            gameClear = set.isMaxStrike();
        } while (!gameClear);
        OutputView.printGameComplete();
    }

    private static boolean exit() throws IllegalArgumentException {
        String exitInput = InputView.endInput();
        if (exitInput.equals(RESTART)) {
            return false;
        }
        if (exitInput.equals(QUIT)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

}
