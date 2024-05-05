import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class Validation {

    static final String TREE_DIGIT_REGEX = "^[0-9]{3}$";

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
}
