package src.game;

import static src.game.NumberComparator.*;
import static src.game.RandomNumberGenerator.generateRandomNumber;
import static src.io.Input.*;

public class Game {

    private Boolean run = true;
    private int randomNumber = generateRandomNumber();

    public void start() {
        while (run) {
            try {
                int userInput = getGuessNumberFromUser();

                boolean isCorrect = compareNumber(randomNumber, userInput);

                if (isCorrect) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    run = restartOrExit();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                run = false;
            }
        }
    }

    public boolean restartOrExit() {
        switch (getGameOptionFromUser()) {
            case RESTART -> {
                randomNumber = generateRandomNumber();  // 새로운 난수 생성
                return true;
            }
            case EXIT -> {
                return false;
            }
        }
        return false;
    }
}
