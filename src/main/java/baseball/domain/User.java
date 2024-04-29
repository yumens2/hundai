package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    private static final Pattern USER_INPUT_VALIDATION_REGEX = Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$");

    private final List<Integer> numbers;

    private User(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static User from(final String input) {
        validate(input);
        final List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            final int userDigit = Character.getNumericValue(input.charAt(i));
            numbers.add(userDigit);
        }
        return new User(numbers);
    }

    private static void validate(final String input) {
        if (!USER_INPUT_VALIDATION_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("1~9사이의 서로 다른 3자리 숫자만 가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
