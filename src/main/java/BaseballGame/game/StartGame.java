package game;

import io.Input;
import utils.RandomNumber;

import java.util.ArrayList;

public class StartGame {

    public static void startGame() {
        ArrayList<Integer> targetNumbers = RandomNumber.generateRandomNumbers();

        while(true) {
            ArrayList<Integer> inputNumbers = Input.inputNumbers();
            int result_of_the_game = BaseballGame.play(targetNumbers, inputNumbers);

            if (result_of_the_game == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
