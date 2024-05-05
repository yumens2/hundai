package baseball;

public class Application {
    private static final ComputerNum computer = new ComputerNum();
    private static UserNumValidator validator = new UserNumValidator();
    private static GameLogic gameLogic = new GameLogic();
    private static GameStatus gameStatus = new GameStatus();
    private static GameController controller = new GameController();

    public static void main(String[] args) {
        try {
            runGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runGame() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            continuePlaying = playSingleGameSession();
        }
    }

    private static boolean playSingleGameSession() {
        computer.generateComputerNumbers();
        boolean gameWon = false;
        while (!gameWon) {
            String input = controller.getUserInput();
            if (validator.isValidInput(input)) {
                gameWon = evaluateGuess(input);
            }
        }
        return controller.promptForRestart();
    }

    private static boolean evaluateGuess(String input) {
        int strikes = gameLogic.countStrikes(input, computer.getComputerNumbers());
        int balls = gameLogic.countBalls(input, computer.getComputerNumbers(), strikes);
        boolean gameWon = strikes == 3;
        gameStatus.printResult(balls, strikes, gameWon);
        return gameWon;
    }
}