package precourse.game;

public enum EndCommand {
    CONTINUE("1"),
    STOP("2");

    private final String command;

    EndCommand(String command) {
        this.command = command;
    }

    //TODO: 커맨드 입력 받아서 enum 반환하는 메서드 추가

    public String getCommand() {
        return command;
    }
}
