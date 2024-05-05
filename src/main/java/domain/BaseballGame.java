package domain;

public class BaseballGame {

    private final Player computerPlayer;
    private final Player humanPlayer;

    public BaseballGame(Player computerPlayer, Player humanPlayer) {
        this.computerPlayer = computerPlayer;
        this.humanPlayer = humanPlayer;
    }

    public void start() {
        System.out.println("Game Start!");
    }
}
