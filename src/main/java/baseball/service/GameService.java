package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Parse;
import baseball.utils.GenerateRandomNum;
import baseball.view.RequestInput;
import baseball.view.GameMessage;
import java.util.Scanner;

public class GameService {

    int size;
    Game game;
    User user = new User();
    Parse parser = new Parse();
    GameMessage systemMessage = new GameMessage();
    private final Scanner scanner = new Scanner(System.in);
    public void setGame(int size, int start, int end) {
        this.size = size;
        game = new Game(GenerateRandomNum.getRandomNumbers(size, start, end));
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            play();
            systemMessage.printScoreMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void play() {
        game.initBaseBall();
        user.setUserNumbers(getUserNumber());
        computeScore();
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        RequestInput.requestInputData();
        String input = scanner.nextLine();
        return parser.parseUserInput(input, size);
    }

    private void computeScore() {
        for (int i = 0; i < size; i++) {
            compute(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if (gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        increaseCount(index, temp);
    }

    private void increaseCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.increaseBallCount();
        }
        if (temp == index) {
            game.increaseStrikeCount();
        }
    }
}
