package controller;

import java.io.IOException;
import model.Computer;
import model.User;
import service.GameService;
import view.GameView;

public class GameController {
    private GameView view;
    private GameService service;

    public GameController(GameView view, GameService service) {
        this.view = view;
        this.service = service;
    }
    public void startGame() {}

    public void processUserNumber() {}

    public GameView getView() {
        return this.view;
    }

    public GameService getService() {
        return this.service;
    }
}
