import domain.BaseballCount;
import domain.Computer;
import domain.Player;
import domain.Umpire;
import utility.BaseballPrinter;
import utility.InputStringReceiver;
import utility.PlayerNumberValidator;

public class BaseballGame {

    private final Player player;
    private final Computer computer;
    private final Umpire umpire;

    public BaseballGame() {
        this.player = new Player();
        this.computer = new Computer();
        this.umpire = new Umpire();
    }

    public void playBall() {
        do {
            setPlayerNumberWithInput();
            umpire.setBaseballCountWithCalculator(player, computer);
            printBallCountHint(umpire.getBaseballCount());
        } while (!isGameOver());
    }

    private void setPlayerNumberWithInput() {
        BaseballPrinter.printPlayerNumberInputMessage();
        String inputNumber = InputStringReceiver.getInputString();
        PlayerNumberValidator.isPlayerNumberCorrect(inputNumber);
        player.setPlayerNumber(inputNumber);
    }

    private boolean isGameOver() {
        if (umpire.isPlayerWin()) {
            BaseballPrinter.printGameOverMessage();
            BaseballPrinter.printGameRestartInputMessage();
            return true;
        }
        return false;
    }

    private void printBallCountHint(BaseballCount baseballCount) {
        printBallHint(baseballCount.getBallCount());
        printStrikeHint(baseballCount.getStrikeCount());
        printNothingHint(baseballCount.isNothingCount());
        BaseballPrinter.printLineBreak();
    }

    private void printBallHint(int ballCount) {
        if (ballCount > 0) {
            BaseballPrinter.printBallCountHintMessage(ballCount);
        }
    }

    private void printStrikeHint(int strikeCount) {
        if (strikeCount > 0) {
            BaseballPrinter.printStrikeCountHintMessage(strikeCount);
        }
    }

    private void printNothingHint(boolean isNothing) {
        if (isNothing) {
            BaseballPrinter.printNothingHintMessage();
        }
    }
}
