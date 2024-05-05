import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballGame {

    Player computer;
    boolean isEnd;

    public void init() {
        computer = new Player();
        isEnd = false;
    }

    public void game() throws IllegalArgumentException {
        init();
        System.out.println(GameMessageConstant.START_GAME);
        Scanner scanner = new Scanner(System.in);
        String inputNumber;
        String hint;
        do {
            System.out.print(GameMessageConstant.INPUT_NUMBER);
            inputNumber = scanner.next();
            checkInput(inputNumber);
            hint = getHint(inputNumber);
            System.out.println(hint);
        } while (!isEnd);
        System.out.println(GameMessageConstant.GAME_CLEAR);
    }

    public void run() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String inputCommand;
        while (true) {
            game();
            System.out.println(GameMessageConstant.GAME_RESTART_QUESTION);
            inputCommand = scanner.next();
            if (inputCommand.equals(String.valueOf(GameConstant.END_GAME_NUMBER))) {
                break;
            } else if (!inputCommand.equals(String.valueOf(GameConstant.RESTART_GAME_NUMBER))) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(GameMessageConstant.GAME_END);
    }

    private String getHint(String inputNumber) {
        BaseBallGameResult result = computer.checkMatching(input2IntArray(inputNumber));
        checkEnd(result);
        return result2Hint(result);
    }

    private void checkInput(String inputNumber) throws IllegalArgumentException {
        if (!checkTreeDigitNumber(inputNumber) || !checkDuplicateNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkTreeDigitNumber(String inputNumber) {
        String TREE_DIGIT_REGEX = "^[0-9]{3}$";
        return Pattern.compile(TREE_DIGIT_REGEX).matcher(inputNumber).matches();
    }

    private boolean checkDuplicateNumber(String inputNumber) {
        Set<Character> chars = new HashSet<>();
        for (char c : inputNumber.toCharArray()) {
            chars.add(c);
        }
        return chars.size() == GameConstant.NUMBER_COUNT;
    }

    private void checkEnd(BaseBallGameResult result) {
        if (result.strike() == GameConstant.NUMBER_COUNT) {
            isEnd = true;
        }
    }

    private int[] input2IntArray(String inputNumber) {
        int[] guess = new int[GameConstant.NUMBER_COUNT];
        for (int i = 0; i < GameConstant.NUMBER_COUNT; i++) {
            guess[i] = Character.getNumericValue(inputNumber.charAt(i));
        }
        return guess;
    }

    private String result2Hint(BaseBallGameResult result) {
        if (result.ball() == 0 && result.strike() == 0) {
            return GameMessageConstant.NOTHING;
        }
        if (result.ball() == 0) {
            return strike2String(result.strike());
        }
        if (result.strike() == 0) {
            return ball2String(result.ball());
        }
        return ball2String(result.ball()) + " " + strike2String(result.strike());
    }

    private String ball2String(int ball) {
        if (ball > 0) {
            return String.format("%d%s", ball, GameMessageConstant.BALL);
        }
        return "";
    }

    private String strike2String(int strike) {
        if (strike > 0) {
            return String.format("%d%s", strike, GameMessageConstant.STRIKE);
        }
        return "";
    }
}
