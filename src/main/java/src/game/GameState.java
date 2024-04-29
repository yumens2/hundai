package src.game;

public enum GameState {
    RESTART(1, true), EXIT(2, false);

    private final int value;
    private final boolean continueGame;

    GameState(int value, boolean continueGame) {
        this.value = value;
        this.continueGame = continueGame;
    }

    public int getValue() {
        return value;
    }

    public boolean isContinueGame() {
        return continueGame;
    }

    public static GameState valueOf(int value) {
        for (GameState option : GameState.values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("입력한 값이 적절하지 않습니다. [1,2] 중에 선택해주세요.");
    }
}
