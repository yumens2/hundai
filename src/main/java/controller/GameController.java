package controller;

import service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void play() {
        setGame();
    }

    private void setGame() {
        gameService.setGame();
    }

}
