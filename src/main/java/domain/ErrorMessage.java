package domain;

public enum ErrorMessage {
    DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    INVALID_LENGTH("%d자리 숫자가 아닙니다."),
    INVALID_NUMBER("%d에서 %d까지의 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
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
