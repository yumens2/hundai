package src.game;

import static src.io.Input.*;

public class Game {

    private Boolean run = true;
    private Integer userInput = null;

    public void start() {
        System.out.println("Game Start!");

        while (run) {
            try {
                userInput = getGuessNumberFromUser();

                //TODO: 게임 로직 구현

                run = restartOrExit();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                run = false;
            }
        }
    }

    public boolean restartOrExit() {
        switch (getGameOptionFromUser()) {
            case RESTART -> {
                System.out.println("RESTART");
                //TODO: 초기화 코드
                return true;
            }
            case EXIT -> {
                System.out.println("EXIT");
                return false;
            }
        }
        return false;
    }
}
