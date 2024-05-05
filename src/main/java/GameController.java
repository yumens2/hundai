import java.util.List;
import java.util.Scanner;

public class GameController {
    private Computer computer;
    private Player player;
    private Compare compare;
    private Scanner scanner;

    public GameController() {
        this.computer = new Computer();
        this.player = new Player();
        this.compare = new Compare();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            playBaseball();
            keepPlaying = promptForRestart();
        }
    }

    private boolean promptForRestart() {
        System.out.println("게임을 새로 시작하려면 1을, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                return true;
            case "2":
                System.out.println("게임을 종료합니다.");
                return false;
            default:
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private void playBaseball() {
        List<Integer> computerNumbers = computer.generateNum();
        String result;
        do {
            player.inputNumber();
            List<Integer> playerNumbers = player.getNumber();
            result = compare.compareNumbers(computerNumbers, playerNumbers);
            System.out.println(result);
        } while (!"3스트라이크".equals(result));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

