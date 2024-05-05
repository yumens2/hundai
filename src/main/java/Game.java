import constant.GameConstant;
import constant.GameMessageConstant;
import java.util.Scanner;

public class Game {

    Player computer;
    boolean isEnd;

    public void run() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String inputCommand;
        do {
            game();
            System.out.println(GameMessageConstant.GAME_RESTART_QUESTION);
            inputCommand = scanner.next();
            if (Validation.checkEndCommand(inputCommand)) {
                throw new IllegalArgumentException();
            }
        } while (Integer.parseInt(inputCommand) != GameConstant.END_GAME_NUMBER);
        System.out.println(GameMessageConstant.GAME_END);
    }

    public void init() {
        computer = new Player();
        isEnd = false;
    }

    public void game() throws IllegalArgumentException {
        init();
        System.out.println(GameMessageConstant.START_GAME);
        Scanner scanner = new Scanner(System.in);
        String inputNumber;
        GameResult result;
        Hint hint;
        do {
            System.out.print(GameMessageConstant.INPUT_NUMBER);
            inputNumber = scanner.next();
            checkInputNumber(inputNumber);
            result = getResult(inputNumber);
            hint = new Hint(result);
            System.out.println(hint.getHint());
        } while (!isEnd);
        System.out.println(GameMessageConstant.GAME_CLEAR);
    }

    private GameResult getResult(String inputNumber) {
        GameResult result = computer.checkMatching(input2IntArray(inputNumber));
        checkEnd(result);
        return result;
    }

    private void checkInputNumber(String inputNumber) throws IllegalArgumentException {
        if (!Validation.checkThreeDigitNumber(inputNumber) || !Validation.checkDuplicateNumber(
                inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkEnd(GameResult result) {
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

}
