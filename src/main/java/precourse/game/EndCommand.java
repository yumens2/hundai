package precourse.game;

import java.util.Arrays;
import java.util.Optional;

public enum EndCommand {
    CONTINUE("1"),
    STOP("2");

    private final String command;

    EndCommand(String command) {
        this.command = command;
    }

    public static Optional<EndCommand> commandOf(String command){
        return Arrays.stream(values())
                .filter(gameEndCommand -> gameEndCommand.getCommand().equals(command))
                .findAny();
    }

    public String getCommand() {
        return command;
    }
}
