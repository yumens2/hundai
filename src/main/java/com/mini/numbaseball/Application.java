package com.mini.numbaseball;

import com.mini.numbaseball.controller.GameController;
import com.mini.numbaseball.model.GameModel;
import com.mini.numbaseball.view.GameView;

public class Application {

    public static void main(String[] args) {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);

        try {
            gameController.play();
        } catch (IllegalArgumentException e) {
            gameView.displayException(e);
        }

        gameView.displayEnd();
    }

}
