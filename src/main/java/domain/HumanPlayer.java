package domain;

import infra.IOHandler;

public class HumanPlayer implements Player {

    private final IOHandler ioHandler = new IOHandler();

    @Override
    public void generateNumbers() {
        String input = getInput();

        validateInput(input);

        while (!isValidInput(input)) {
            ioHandler.print(Message.INVALID_INPUT.getMessage());
            input = ioHandler.getStringInput();
        }
    }

    public String getInput() {
        ioHandler.print(Message.INPUT_NUMBER.getMessage());
        return ioHandler.getStringInput();
    }

    private void validateInput(String input) {
        if (input.length() != BaseballGame.NUMBER_SIZE) {
            throw new IllegalArgumentException(Message.INVALID_LENGTH.getMessage());
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException(Message.INVALID_NUMBER.getMessage());
        }
        if (hasDuplicatedNumber(input)) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER.getMessage());
        }
    }

    private boolean isValidInput(String input) {
        return input.length() == BaseballGame.NUMBER_SIZE && isNumber(input) && !hasDuplicatedNumber(input);
    }

    private boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private boolean hasDuplicatedNumber(String input) {
        return input.chars().distinct().count() != BaseballGame.NUMBER_SIZE;
    }
}
