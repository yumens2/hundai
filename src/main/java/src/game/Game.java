package src.game;

import static src.game.NumberComparator.*;
import static src.game.RandomNumberGenerator.generateRandomNumber;
import static src.io.Input.*;

import src.io.Input;

public class Game {

    private final Input input;
    private GameState state;
    private int randomNumber;

    public Game(Input input) {
        this.input = input;
        resetGame();
    }

    public GameState getState() {
        return state;
    }

    private void resetGame() {
        state = GameState.RESTART;
        randomNumber = generateRandomNumber();  // 새로운 난수 생성
    }

    public void start() {
        while (state.isContinueGame()) {
            playRound();
        }
    }

    private void playRound() {
        try {
            int userInput = input.getGuessNumberFromUser();

            boolean isCorrect = compareNumber(randomNumber, userInput);

            if (isCorrect) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                updateGameState();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            state = GameState.EXIT;
        }
    }

    public void updateGameState() {
        state = input.getGameStateFromUser();
    }
}
