package controller;

import model.Hints;
import model.Number;
import service.GameService;
import service.RandomGenerator;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService(new RandomGenerator());
    }

    public void playGame() {

        do {
            playOneTurn();
        } while (gameService.isContinuing());

    }

    public void playOneTurn() {
        Number answer = gameService.getAnswer();

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int input = gameService.getInput();
            Number userInput = gameService.checkingCondition(input);

            Hints hints = gameService.compareNumbers(userInput.getNumbers(),
                answer.getNumbers()); // result[0]: strike, result[1]: ball

            if (gameService.isAnswered(hints)) {
                break;
            } else {
                gameService.printHints(hints);
            }
        }

    }
}
