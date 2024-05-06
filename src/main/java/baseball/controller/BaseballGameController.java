package baseball.controller;

import baseball.service.GameService;
import baseball.view.GameMessage;
import baseball.view.RequestInput;
import java.util.Scanner;

public class BaseballGameController {
    final int SIZE = 3;
    final int START= 1;
    final int END = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();
    private Scanner scanner = new Scanner(System.in);

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(SIZE, START, END);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        GameMessage.printGameOverMessage();
    }

    /*
     - 유저입력이 (문자 or 개수가 0 or 3 이상)  : Exception
     - 유저입력이 (1)                        : 재시작
     - 유저입력이 (2)                        : 종료
     */
    private void askRetry() throws IllegalArgumentException {
        RequestInput.printRetryMessage();
        if (getInputNum() == RETRY) {
            run();
        }
    }

    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(scanner.nextLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
