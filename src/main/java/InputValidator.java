import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void validateInput(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("입력은 정확히 3자리 숫자여야 합니다.");
        }

        Set<Character> seenDigits = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0') {
                throw new IllegalArgumentException("입력은 1부터 9까지의 숫자여야 합니다.");
            }

            if (!seenDigits.add(ch)) {
                throw new IllegalArgumentException("모든 숫자는 서로 달라야 합니다.");
            }
        }
    }
}
