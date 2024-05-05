package domain;

public class BaseballGame {

    private final Player computerPlayer = new ComputerPlayer();
    private final Player humanPlayer = new HumanPlayer();

    public void start() {
        System.out.println("Game Start!");
    }
}
