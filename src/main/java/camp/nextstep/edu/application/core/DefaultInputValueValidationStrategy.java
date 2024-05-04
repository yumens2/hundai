package camp.nextstep.edu.application.core;

public class DefaultInputValueValidationStrategy implements InputValueValidationStrategy {

    @Override
    public boolean isValid(String value) {
        if (value == null || !value.matches("^[1-9]{3}$")) {
            return false;
        }
        int[] numbers = value.chars().map(Character::getNumericValue).toArray();
        return numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[2] != numbers[0];
    }
}
