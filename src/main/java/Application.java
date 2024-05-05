import game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BaseballGame baseballGame = appConfig.baseballGame();
        baseballGame.gameStart();
    }
}