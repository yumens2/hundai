import constant.GameConstant;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class Validation {

    static final String TREE_DIGIT_REGEX = "^[0-9]{3}$";
    static final String ONE_DIGIT_REGEX = "^[0-9]{1}$";

    public static boolean checkThreeDigitNumber(String inputNumber) {
        return Pattern.compile(TREE_DIGIT_REGEX).matcher(inputNumber).matches();
    }

    public static boolean checkDuplicateNumber(String inputNumber) {
        Set<Character> chars = new HashSet<>();
        for (char c : inputNumber.toCharArray()) {
            chars.add(c);
        }
        return chars.size() == GameConstant.NUMBER_COUNT;
    }

    public static boolean checkEndCommand(String inputCommand) {
        if (!Pattern.compile(ONE_DIGIT_REGEX).matcher(inputCommand).matches()) {
            return false;
        }
        int command = Integer.parseInt(inputCommand);
        return command == GameConstant.END_GAME_NUMBER
                || command == GameConstant.RESTART_GAME_NUMBER;
    }
}
