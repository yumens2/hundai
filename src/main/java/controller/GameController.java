package controller;

import java.util.Scanner;
import model.Hints;
import model.Number;
import service.GameService;
import service.RandomGenerator;

public class GameController {

    private final GameService gameService;
    private final Scanner sc;

    public GameController() {
        this.gameService = new GameService(new RandomGenerator());
        this.sc = new Scanner(System.in);
    }

    public void playGame() {
        GameService.setScanner(sc);
        do {
            Number answer = gameService.getAnswer();
            playOneTurn(answer);
        } while (isContinuing());

    }

    public void playOneTurn(Number answer) {

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            int input = gameService.getInput();
            Number userInput = gameService.checkingCondition(input);

            Hints hints = gameService.compareNumbers(userInput.getNumbers(),
                answer.getNumbers()); // result[0]: strike, result[1]: ball

            if (gameService.isAnswered(hints)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else {
                gameService.printHints(hints);
            }
        }

    }

    public boolean isContinuing() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return gameService.getInput() == 1;
    }
}
