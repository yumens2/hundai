package domain;

public enum Message {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    INVALID_INPUT("입력이 잘못되었습니다."),
    GAME_OVER("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int count) {
        return String.format(this.message, count);
    }

    public String getMessage(int count1, int count2) {
        return String.format(this.message, count1, count2);
    }

}

