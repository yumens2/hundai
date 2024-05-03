package precourse.game;

public enum Messages {
    REQUIRE_NUMBERS("숫자를 입력해주세요."),
    REQUIRE_END_COMMAND("게임을 새로 시작하려면 "+ EndCommand.CONTINUE.getCommand()
            + ", 종료하려면 " + EndCommand.STOP.getCommand() + "를 입력하세요."),
    ALL_STRIKE_FORMAT("%d개의 숫자를 모두 맞추셨습니다! 게임종료"),

    NOT_STARTED("게임이 시작되지 않았습니다."),
    ALREADY_STARTED("게임이 시작된 상태입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
