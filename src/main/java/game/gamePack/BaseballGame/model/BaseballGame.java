package game.gamePack.BaseballGame.model;

import game.gamePack.BaseballGame.validator.Validator;
import game.gamePack.BaseballGame.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private static final String START = "1";

    private BaseballGame() {
    }

    /**
     * 다중쓰레드 환경에서 싱글톤 보장 안됨
     */
//    public static BaseballGame of() {
//        if (baseballGame == null) {
//            baseballGame = new BaseballGame();
//        }
//        return baseballGame;
//    }

    /**
     * static inner class를 이용한 싱글톤 패턴 클래스가 로딩될 때 생성되기 때문에 thread-safe 함 lazy loading이 가능하며, of()
     * 메소드가 호출되기 전까지는 객체가 생성되지 않음
     */
    private static class BaseballGameHolder {

        private static final BaseballGame baseballGame = new BaseballGame();
    }

    public static BaseballGame of() {
        return BaseballGameHolder.baseballGame;
    }

    public List<Integer> GuessNumbers() {
        String userNumbers = InputView.printGuessMessage();
        Validator.validGuessNumber(userNumbers);
        return userNumbers.chars()
            .mapToObj(c -> Integer.parseInt(String.valueOf((char) c)))
            .collect(Collectors.toList());
    }


    public boolean exitGame() {
        String restart = InputView.inputRestart();
        Validator.validRestart(restart);
        return restart.equals(START);
    }
}
