import domain.BaseballCount;
import domain.Computer;
import domain.Player;
import domain.Umpire;
import utility.ConsoleMessagePrinter;
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
            umpire.setBaseballCountWithCalculator(player.getPlayerNumber(), computer.getAnswerNumber());
            showBallCountHint(umpire.getBaseballCount());
        } while (!isGameOver());
    }

    private void setPlayerNumberWithInput() {
        ConsoleMessagePrinter.printPlayerNumberInputMessage();
        String inputNumber = InputStringReceiver.getInputString();
        PlayerNumberValidator.checkPlayerNumberCorrect(inputNumber);
        player.setPlayerNumber(inputNumber);
    }

    private boolean isGameOver() {
        if (umpire.isPlayerWon()) {
            ConsoleMessagePrinter.printGameOverMessage();
            return true;
        }
        return false;
    }

    private void showBallCountHint(BaseballCount baseballCount) {
        showBallHint(baseballCount.getBallCount());
        showStrikeHint(baseballCount.getStrikeCount());
        showNothingHint(baseballCount.isNothingCount());
        ConsoleMessagePrinter.printLineBreak();
    }

    private void showBallHint(int ballCount) {
        if (ballCount > 0) {
            ConsoleMessagePrinter.printBallCountHintMessage(ballCount);
        }
    }

    private void showStrikeHint(int strikeCount) {
        if (strikeCount > 0) {
            ConsoleMessagePrinter.printStrikeCountHintMessage(strikeCount);
        }
    }

    private void showNothingHint(boolean isNothing) {
        if (isNothing) {
            ConsoleMessagePrinter.printNothingHintMessage();
        }
    }
}
