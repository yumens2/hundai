import model.Hints;
import model.Number;
import service.GameService;
import service.RandomGenerator;

public class Game {

    private final GameService gameService;

    public Game() {
        this.gameService = new GameService(new RandomGenerator());
    }

    public void playGame() {

        while (true) {

            System.out.print("숫자를 입력해주세요: ");
            int input = gameService.getInput();
            Number userInput = gameService.checkingCondition(input);

            Number answer = gameService.getAnswer();

            Hints hints = gameService.compareNumbers(userInput.getNumbers(),
                answer.getNumbers()); // result[0]: strike, result[1]: ball

            if (gameService.isAnswered(hints)) {
                if (!gameService.isContinuing()) {
                    break;
                }
            } else {
                gameService.printHints(hints);
            }

        }
    }
}
