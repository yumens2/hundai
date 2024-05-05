package userinterface;

import java.util.Set;

import static userinterface.constant.ErrorConstants.*;

public class InputValidator {

    public void validateGuess(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException(GUESS_ERROR_MESSAGE);
        }
        try {
            Set<Character> inputSet = Set.of(input.charAt(0), input.charAt(1), input.charAt(2));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(GUESS_DUPLICATED_ERROR_MESSAGE);
        }
    }

    public void validateReplay(String input) {
        if (!input.matches("[1-2]")) {
            throw new IllegalArgumentException(REPLAY_ERROR_MESSAGE);
        }
    }
}
