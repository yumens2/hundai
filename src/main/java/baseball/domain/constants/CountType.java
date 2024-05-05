package baseball.domain.constants;

public enum CountType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    private CountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
