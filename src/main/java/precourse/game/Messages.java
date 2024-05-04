package precourse.game;

public enum Messages {
    REQUIRE_NUMBERS("숫자를 입력해주세요."),
    REQUIRE_END_COMMAND("게임을 새로 시작하려면 "+ EndCommand.CONTINUE.getCommand()
            + ", 종료하려면 " + EndCommand.STOP.getCommand() + "를 입력하세요."),
    ALL_STRIKE_FORMAT("%d개의 숫자를 모두 맞추셨습니다! 게임종료"),

    NOT_STARTED("게임이 시작되지 않았습니다."),
    NOT_ENDED("게임이 끝난 상태가 아닙니다."),
    ALREADY_STARTED("게임이 시작된 상태입니다."),
    INVALID_NUMBER_LENGTH("숫자 길이는 1 ~ 9여야 합니다."),
    INVALID_COMMAND("올바르지 않은 명령어입니다."),
    NOT_MATCHED_LENGTH("길이가 맞지 않습니다"),
    INVALID_NUMBER("올바른 숫자가 아닙니다"),
    NOT_UNIQUE_DIGITS("중복된 숫자가 있습니다"),

    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
