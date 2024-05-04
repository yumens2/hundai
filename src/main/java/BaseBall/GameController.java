package BaseBall;
import Model.InputValidator;
import Model.NumberGenerator;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private List<Integer> computerNumbers;
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        computerNumbers = NumberGenerator.generateUniqueNumbers();
        System.out.println("게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = scanner.nextLine();
            if (!InputValidator.isValid(input)) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
            String result = GameResult.calculateResult(computerNumbers, input);
            System.out.println(result);
            if (result.contains("게임 종료")) {
                if (askForNewGame()) {
                    startGame();
                } else {
                    break;
                }
            }
        }
    }

    private boolean askForNewGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = scanner.nextLine();
        return "1".equals(input);
    }
}
