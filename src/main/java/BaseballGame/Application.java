public class Application {
    private static StartGame startGame = new StartGame();
    private static RandomNumber randomNumberGenerator = new RandomNumber();
    private static Input input = new Input();
    private static BaseballGame baseballGame = new BaseballGame();
    private static ContinueOrNot continueOrNot = new ContinueOrNot();

    public static void main(String[] args) {
        boolean isContinue = true;

        while(isContinue) {
            startGame.startGame();
            isContinue = continueOrNot.isContinueGame();
        }
    }
}
