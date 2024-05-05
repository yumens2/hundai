package domain;

public enum Message {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    INVALID_INPUT("입력이 잘못되었습니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    INVALID_LENGTH("3자리 숫자가 아닙니다."),
    INVALID_NUMBER("1에서 9까지의 숫자가 아닙니다."),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
