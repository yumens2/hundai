package controller;

import domain.Computer;
import domain.ScoreEvaluator;
import domain.User;
import util.Constants;

public class GameManager {
    private final Computer computer;
    private final User user;
    private final ScoreEvaluator scoreEvaluator;

    public GameManager() {
        this.computer = new Computer();
        this.user = new User();
        this.scoreEvaluator = new ScoreEvaluator();
    }

    public void gameStart() {
        do {
            computer.generateRandomNumber();
            playRound();
        } while (user.wantToRestart());
    }

    private void playRound() {
        int strikeCount;
        do {
            user.inputUserNumber();
            strikeCount = scoreEvaluator.evaluateScore(user.getUserNumber(), computer.getComputerNumber());
        } while (strikeCount < Constants.WIN_CONDITION);
        System.out.println(Constants.GAME_END_MESSAGE);
    }
}