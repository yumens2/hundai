package game.gamePack.BaseballGame.model;

import game.gamePack.BaseballGame.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private static String START = "1";
    private static String END = "2";
    private static BaseballGame baseballGame;

    private BaseballGame() {
    }

    public static BaseballGame of() {
        if (baseballGame == null) {
            baseballGame = new BaseballGame();
        }
        return baseballGame;
    }

    public List<Integer> GuessNumbers() {
        String userNumbers = InputView.printGuessMessage();
        return userNumbers.chars()
            .mapToObj(c -> Integer.parseInt(String.valueOf((char) c)))
            .collect(Collectors.toList());
    }


    public boolean exitGame() {
        String restart = InputView.inputRestart();
        return restart.equals(START);
    }
}
