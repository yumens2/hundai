package controller;

import service.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void play() {
        startGame();
    }

    private void startGame() {
        gameService.startGame();
    }

}
