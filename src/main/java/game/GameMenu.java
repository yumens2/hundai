package game;

public enum GameMenu {
    RESTART(1, "재시작"), EXIT(2, "종료");

    private final int menuCode;
    private final String description;

    GameMenu(int menuCode, String description) {
        this.menuCode = menuCode;
        this.description = description;
    }

    public static GameMenu findByCode(int menuCode) {
        for(GameMenu gameMenu : GameMenu.values()) {
            if(gameMenu.menuCode == menuCode) {
                return gameMenu;
            }
        }
        return null;
    }
}