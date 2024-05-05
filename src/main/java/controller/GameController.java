package controller;

import model.BallCountStatus;
import model.Computer;
import model.User;

import java.util.*;

public class GameController {
    private User user;
    private Computer computer;
    private InputController inputController;
    private ScoreController scoreController;
    private static final String ALL_STRIKE_MESSAGE = "3스트라이크";


    public GameController(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
        this.inputController = new InputController();
        this.scoreController = new ScoreController();
    }

    public void startGame() {
        setComputerNumbers();
        String result = "";
        while (!result.equals(ALL_STRIKE_MESSAGE)) {
            setUserNumbers();
            result = scoreController.calculateScore(user, computer);
            System.out.println(result);
        }
        System.out.println("승리!");
    }

    public void setUserNumbers() {
        user.setNumberList(inputController.generateUserNum());
    }

    public void setComputerNumbers() {
        computer.setNumberSet(inputController.generateComputerNum());
    }

}
