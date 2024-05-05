package baseball.exception.constants;

import baseball.system.constants.Command;
import baseball.system.constants.Rule;

public enum ErrorMessage {
    INVALID_ARGUMENT_RANGE(
        "%d ~ %d 사이 값만 허용합니다.".formatted(Rule.MINIMUM_NUMBER, Rule.MAXIMUM_NUMBER)),
    DUPLICATE_INPUT("중복된 원소를 입력할 수 없습니다."),
    INVALID_INPUT_SIZE("%d자리 숫자를 입력해주세요.".formatted(Rule.BASEBALL_NUMBER_SIZE)),
    INVALID_INPUT_TRY_AGAIN("%s 또는 %s 를 입력해주세요.".formatted(Command.RESTART, Command.EXIT));
    private final String description;

    private ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
