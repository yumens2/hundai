import java.util.List;

public class Application {
    private final Computer computer;
    private final Player player;
    private final Restart restart;

    public Application(Computer computer, Player player, Restart restart) {
        this.computer = computer;
        this.player = player;
        this.restart = restart;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Restart restart = new Restart();
        Application app = new Application(computer, player, restart);
        app.run();
    }

    public void run() {
        do {
            playGame();
        } while (restart.askForRestart());
    }

    private void playGame() {
        boolean gameWon = false;

        while (!gameWon) {
            try {
                List<Integer> playerGuess = player.guess();
                String feedback = Compare.getFeedback(computer.getNumbers(), playerGuess);
                System.out.println(feedback);
                gameWon = feedback.equals("3 스트라이크");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}