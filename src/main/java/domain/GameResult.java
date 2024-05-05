package domain;

public enum GameResult {
    NONE("낫싱"),
    STRIKE("스트라이크 %d개"),
    BALL("볼 %d개");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(int count) {
        return String.format(this.message, count);
    }
}
