import java.util.List;
import java.util.Scanner;

public class Game {
    private Computer computer;
    private Player player;
    private Referee referee;
    private GameView gameView;
    protected boolean isRunning;
    protected List<Integer> computerNumbers;

    public Game() {
        computer = new Computer();
        player = new Player();
        referee = new Referee();
        gameView = new GameView();
        isRunning = true;
        computerNumbers = computer.generateAnswer();
    }

    /**
     * 게임을 시작하고 전체적인 로직을 관리하는 메소드
     */
    public void start() {
        while (isRunning) {
            gameView.displayNumberInputRequest();
            String input = getPlayerInput();
            List<Integer> playerNumbers = player.convertInputToList(input);

            int[] result = referee.determineResult(computerNumbers, playerNumbers);
            gameView.displayResult(result[0], result[1]);

            if (result[0] == 3) {
                gameView.displayGameWonMessage();
                isRunning = askForRestart();
                computerNumbers = computer.generateAnswer();
            }
        }
    }

    /**
     * Scanner로 사용자의 입력을 받는 메소드
     * @return 사용자의 입력값
     */
    protected String getPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * 정답을 맞힌 후 재시작 여부를 물어보는 메소드
     * @return
     */
    protected boolean askForRestart() {
        gameView.displayPlayAgainMessage();
        String input = getPlayerInput();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
        return input.equals("1");
    }

}