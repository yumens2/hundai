package camp.nextstep.edu.application.core;

public class DefaultInputValueValidationStrategy implements InputValueValidationStrategy {

    @Override
    public void validate(String value) {
        if (value == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        if (value.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }
        if (!value.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("입력값은 1에서 9까지의 서로 다른 숫자여야 합니다.");
        }
        int[] numbers = value.chars().map(Character::getNumericValue).toArray();
        if(numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] != numbers[0]) {
            throw new IllegalArgumentException("입력값은 1에서 9까지의 서로 다른 숫자여야 합니다.");
        }
    }
}
