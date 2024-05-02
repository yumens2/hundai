import java.util.HashSet;
import java.util.regex.Pattern;
public class Validate {
    public Boolean numberValidate(String input) {
        HashSet<Character> characters = new HashSet<>();
        /*
            입력이 null 인 경우
         */
        if (input == null) {
            return Boolean.FALSE;
        }

        /*
            세 자리 수가 아닌 경우
         */
        if (input.length() != 3) {
            return Boolean.FALSE;
        }

        /*
            세 자리가 숫자가 아닌 경우
         */
        if (!Pattern.matches("[1-9][1-9][1-9]", input)) {
            return Boolean.FALSE;
        }

        /*
            중복된 숫자가 있는 경우
         */
        for (Character c : input.toCharArray()) {
            characters.add(c);
        }
        if (characters.size() != 3) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
