package precourse.game;

public enum Messages {
    REQUIRE_NUMBERS("숫자를 입력해주세요."),
    ALL_STRIKE_FORMAT("%d개의 숫자를 모두 맞추셨습니다! 게임종료");

    //TODO: EndCommand 구현하고 메세지 추가

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
