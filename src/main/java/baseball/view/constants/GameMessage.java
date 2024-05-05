package baseball.view.constants;

import baseball.system.constants.Command;
import baseball.system.constants.Rule;

public enum GameMessage {
    INPUT("숫자를 입력해 주세요 : "),
    EXIT("%d개의 숫자를 모두 맞히셨습니다! 게임 종료".formatted(Rule.BASEBALL_NUMBER_SIZE)),
    RESTART("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.".formatted(Command.RESTART, Command.EXIT));

    private final String description;

    private GameMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
