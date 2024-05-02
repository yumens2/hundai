import java.util.HashSet;
import java.util.regex.Pattern;
public class Validate {
    public Boolean numberValidate(String input) {
        HashSet<Character> characters = new HashSet<>();
        if (input == null) {
            return Boolean.FALSE;
        }
        if (input.length() != 3) {
            return Boolean.FALSE;
        }
        if (!Pattern.matches("[1-9][1-9][1-9]", input)) {
            return Boolean.FALSE;
        }
        for (Character c : input.toCharArray()) {
            characters.add(c);
        }
        if (characters.size() != 3) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
