import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Application {
    private NumberGenerator numberGenerator = new NumberGenerator();
    private InputHandler inputHandler = new InputHandler();
    private InputValidator inputValidator = new InputValidator();
    private ResultCalculator resultCalculator = new ResultCalculator();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void startGame() {
        boolean mainGameContinues = true;

        while (mainGameContinues) {
            Set<Integer> computerNumbers = numberGenerator.generateRandomNumbers();
            boolean roundContinues = true;

            while (roundContinues) {
                roundContinues = playRound(computerNumbers);
            }

            mainGameContinues = askToContinue();
        }
    }

    private boolean playRound(Set<Integer> computerNumbers) {
        try {
            String userInput = inputHandler.getUserInput();
            inputValidator.validateInput(userInput);
            String result = resultCalculator.calculateResult(computerNumbers, userInput);
            System.out.println(result);

            if ("3스트라이크".equals(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return false;
            }
            return true;
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("에러: " + e.getMessage());
            return false; // 에러 발생 시 게임 종료
        }
    }

    private boolean askToContinue() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        try {
            String decision = br.readLine();
            if ("1".equals(decision)) {
                return true;
            } else if ("2".equals(decision)) {
                return false;
            } else {
                System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("입력 도중 오류가 발생했습니다: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.startGame();
    }
}
