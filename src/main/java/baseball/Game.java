package baseball;

import java.util.Scanner;

public class Game {
    private User user;
    private Computer computer;
    private final Scanner scanner;

    public Game(User user, Computer computer, Scanner scanner) {
        this.user = user;
        this.computer = computer;
        this.scanner = scanner;
    }

    public void play() {
        boolean option = true;
        computer.initProblemNum();

        while (option) {
            System.out.print("숫자를 입력해 주세요 : ");
            GameResult gameResult = getGameResult(user.makeGuess(), computer.getProblemNum());
            printGameResult(gameResult);

            if (gameResult.isCorrect())
                option = getOption();
        }
    }

    private boolean getOption() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();

        boolean result;
        switch (input) {
            case "1" -> {
                result = true;
                computer.initProblemNum();
            }
            case "2" -> result = false;
            default -> throw new IllegalArgumentException();
        }

        return result;
    }

    private void printGameResult(GameResult gameResult) {
        System.out.println(gameResult);
    }

    private GameResult getGameResult(String guessNum, String answer) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < guessNum.length(); ++i) {
            if (isStrike(guessNum, answer, i))
                ++strikeCount;
            if (getBallCount(guessNum, answer, i))
                ++ballCount;
        }

        return new GameResult(ballCount, strikeCount);
    }

    private boolean isStrike(String guessNum, String answer, int i) {
        return guessNum.charAt(i) == answer.charAt(i);
    }

    private boolean getBallCount(String guessNum, String answer, int i) {
        for (int j = 0; j < guessNum.length(); ++j) {
            if (i != j && guessNum.charAt(i) == answer.charAt(j))
                return true;
        }
        return false;
    }
}
