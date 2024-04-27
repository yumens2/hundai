package src.game;

public enum GameOption {
    RESTART(1), EXIT(2);

    private final int value;

    GameOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameOption valueOf(int value) {
        for (GameOption option : GameOption.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("입력한 값이 적절하지 않습니다. [1,2] 중에 선택해주세요.");
    }
}
