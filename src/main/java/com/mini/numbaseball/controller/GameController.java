package com.mini.numbaseball.controller;

import com.mini.numbaseball.model.GameModel;
import com.mini.numbaseball.view.GameView;

public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    private boolean isReplay = false;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public int validateInput(String userInput) {
        int input;

        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값이 세 자리가 아닙니다.");
        }

        try {
            input = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }

        int tempInput = input;
        int first = tempInput / 100;
        int second = (tempInput / 10) % 10;
        int third = tempInput % 10;

        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException("입력값에 중복된 숫자가 있습니다.");
        }

        if (first == 0 || second == 0 || third == 0) {
            throw new IllegalArgumentException("입력값에 1부터 9까지의 숫자가 아닌 값이 포함되어 있습니다.");
        }

        return input;
    }

    public boolean validateIsReplay(String userInput) {
        int input;

        try {
            input = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }

        if (input == 1) {
            return true;
        } else if (input == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("입력값이 1 또는 2가 아닙니다.");
        }
    }

    public void play() {
        gameModel.initAnswer();
        while (true) {
            try {
                playGuess();
            } catch (IllegalArgumentException e) {
                throw e;
            }

            if (!gameModel.getIsCorrect()) {
                continue;
            }

            if (isReplay) {
                gameModel.initAnswer();
            } else {
                break;
            }
        }
    }

    public void playGuess() {
        try {
            int userGuess = validateInput(gameView.getUserInput());
            String result = gameModel.createResult(userGuess, gameModel.getAnswer());
            gameView.displayResult(result);

            if (gameModel.getIsCorrect()) {
                isReplay = validateIsReplay(gameView.getIsReplay());
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public boolean getIsReplay() {
        return isReplay;
    }
}
