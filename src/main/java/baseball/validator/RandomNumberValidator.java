package baseball.validator;

import static baseball.exception.constants.ErrorMessage.*;

import baseball.system.constants.Rule;

public class RandomNumberValidator {

    private RandomNumberValidator() {
    }

    public static void validateDistinctNumberSize(int length) {
        if (length < Rule.MINIMUM_NUMBER || length > Rule.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_RANGE.getDescription());
        }
    }
}
