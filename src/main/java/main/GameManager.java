package main;

import java.util.Scanner;

public class GameManager {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        while (true) {
            String computerNumber = numberGenerator.generateNumber();
            System.out.println("새 게임이 시작되었습니다. 숨겨진 숫자를 맞추어 보세요.");
            boolean gameWon = false;

            while (!gameWon) {
                System.out.print("숫자를 입력해 주세요 : ");
                String playerGuess = scanner.nextLine();
                if (playerGuess.equals("exit")) {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
                if (!numberGenerator.isValidNumber(playerGuess)) {
                    System.out.println("잘못된 입력입니다. 1부터 9까지 서로 다른 3자리 수를 입력해야 합니다.");
                    continue;
                }
                String result = checkGuess(computerNumber, playerGuess);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 아무 키나 누르세요.");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    public String checkGuess(String computerNumber, String playerGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == playerGuess.charAt(i)) {
                strikes++;
            } else if (computerNumber.contains(String.valueOf(playerGuess.charAt(i)))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        return (strikes > 0 ? strikes + "스트라이크" : "") + (balls > 0 ? " " + balls + "볼" : "").trim();
    }
}
