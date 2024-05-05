package domain;

import static domain.ErrorMessage.DUPLICATED_NUMBER;
import static domain.ErrorMessage.INVALID_LENGTH;
import static domain.ErrorMessage.INVALID_NUMBER;

import infra.IOHandler;
import java.util.ArrayList;

public class HumanPlayer implements Player {

    private final IOHandler ioHandler = new IOHandler();
    private ArrayList<Integer> numbers = new ArrayList<>();

    @Override
    public void generateNumbers() {
        String input = getInput();

        validateInput(input);

        while (!isValidInput(input)) {
            input = ioHandler.getStringInput();
        }

        numbers.clear();
        for (int i = 0; i < BaseballGame.NUMBER_SIZE; i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    public String getInput() {
        return ioHandler.getStringInput();
    }


    private void validateInput(String input) {
        if (input.length() != BaseballGame.NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
        if (hasDuplicatedNumber(input)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
        if (!inRange(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private boolean isValidInput(String input) {
        return input.length() == BaseballGame.NUMBER_SIZE && isNumber(input) && !hasDuplicatedNumber(input);
    }

    private boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private boolean inRange(String input) {
        return input.chars().allMatch(c -> c >= BaseballGame.MIN_NUMBER + '0' && c <= BaseballGame.MAX_NUMBER + '0');
    }

    private boolean hasDuplicatedNumber(String input) {
        return input.chars().distinct().count() != BaseballGame.NUMBER_SIZE;
    }

    @Override
    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
