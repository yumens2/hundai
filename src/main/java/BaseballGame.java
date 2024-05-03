package Game;

import View.Input;
import View.Output;

import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    //게임 진행 메서드 실행 기능
    public static void main(String[] args) {
        boolean continuePlaying = true;
        while (continuePlaying) {
            BaseballGame game = new BaseballGame();
            boolean won = game.playGame();
            if (won) {
                continuePlaying = Input.askForRestart();
            }
        }
    }

    //게임 진행
    public boolean playGame() {
        computerNumbers = RandomNumberGenerator.generateUniqueNumbers();
        while (true) {
            List<Integer> userNumbers = Input.getInputFromUser();
            int[] score = ScoreCalculator.calculateScore(userNumbers, computerNumbers);
            int strikes = score[0];
            int balls = score[1];

            Output.printResult(strikes, balls);
            if (strikes == 3) {
                Output.printMessage("You win!");
                return true;
            }
        }
    }

}