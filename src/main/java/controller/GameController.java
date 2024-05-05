package controller;

import java.io.IOException;
import model.Computer;
import model.User;
import service.GameService;
import view.GameView;

public class GameController implements ITestGameController {
    private GameView view;
    private GameService service;
    private boolean gameActive;

    public GameController(GameView view, GameService service) {
        this.view = view;
        this.service = service;
        this.gameActive = false;
    }
    public void startGame() throws IOException {
        gameActive = true;

        while(gameActive) {
            Computer computer = new Computer();
            User user = new User();

            runGuessLoop(user, computer);

            gameActive = view.checkRestartGame();
        }
    }

    private void runGuessLoop(User user, Computer computer) throws IOException {
        int[] computerNumbers;
        int[] userNumbers;
        while(true) {
            user.setUserInput(view.getUserInput());

            computerNumbers = computer.getNumbers();
            userNumbers = user.getNumbers();

            service.countBall(userNumbers, computerNumbers);
            service.countStrike(userNumbers, computerNumbers);

            view.displayResult(service.getFeedback());
            if(service.getStrikeCount() == 3) {
                break;
            }
        }
        view.displayGameEnd();
    }

    @Override
    public GameView getView() {
        return this.view;
    }

    @Override
    public GameService getService() {
        return this.service;
    }

    @Override
    public boolean isGameActive() {
        return this.gameActive;
    }
}
