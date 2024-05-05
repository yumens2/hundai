package domain;

public enum ErrorMessage {
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    INVALID_LENGTH("3자리 숫자가 아닙니다."),
    INVALID_NUMBER("1에서 9까지의 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
