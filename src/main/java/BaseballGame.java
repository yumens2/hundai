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
        } while (isGameOver());
    }

    private void setPlayerNumberWithInput() throws IllegalStateException {
        String inputNumber = InputNumberReceiver.getInputNumber();
        InputNumberValidator.isPlayerNumberCorrect(inputNumber);
        player.setPlayerNumber(inputNumber);
    }

    public boolean isGameOver() {
        if (umpire.isPlayerWin()) {
            BaseballPrinter.printGameOverMessage();
            return true;
        }
        return false;
    }

    public void printBallCountHint(BaseballCount baseballCount) {
        printBallHint(baseballCount.getBallCount());
        printStrikeHint(baseballCount.getStrikeCount());
        printNothingHint(baseballCount.isNothingCount());
    }

    public void printBallHint(int ballCount) {
        if (ballCount > 0) {
            BaseballPrinter.printBallCountHintMessage(ballCount);
        }
    }

    public void printStrikeHint(int strikeCount) {
        if (strikeCount > 0) {
            BaseballPrinter.printStrikeCountHintMessage(strikeCount);
        }
    }

    public void printNothingHint(boolean isNothing) {
        if (isNothing) {
            BaseballPrinter.printNothingHintMessage();
        }
    }
}
