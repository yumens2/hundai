package controller;

import io.Input;
import io.Output;
import utils.RandomNumbers;
import utils.ResultCalculator;

public class BaseballGame {
    
    public void play() {
        do {
            oneGame();
        } while (newGame());
    }

    private void oneGame() {
        int[] answer = RandomNumbers.generateRandomNumbers();

        do {
            int[] guess;

            try {
                guess = Input.getInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return; // 예외 발생 시 게임 종료
            }

            int strike = ResultCalculator.countStrike(answer, guess);
            int notCatain = ResultCalculator.countNotContain(answer, guess);
            int ball = 3 - (strike + notCatain);

            Output.printOutput(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            
        } while (true);
    }

    private boolean newGame() {
        int choice = Input.getNewGame();

        return choice == 1;
    }
}
