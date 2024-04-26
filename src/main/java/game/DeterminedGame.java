package game;

import io.Input;
import io.Output;

public class DeterminedGame implements Game {
    private Input input;
    private Output output;
    private String computerNumber;
    private String playerNumber;
    public DeterminedGame(Input input, Output output, int num) {
        this.input = input;
        this.output = output;
        this.computerNumber = String.valueOf(num);
    }

    @Override
    public void play() {
        while (true) {
            this.playerNumber = input.getNumberFromPlayer();
            int point = getPointOfMatched();
            output.printResult(convertPointToResult(point));
            if (point == 30) break;
        }
        output.printEnd();
        if (input.getRestartNumberFromPlayer().equals("1"))
            play();
    }

    private String convertPointToResult(int point) {
        StringBuilder result = new StringBuilder();
        int strike = point / 10;
        int ball = point % 10;
        if (ball != 0)
            result.append(ball).append("볼 ");
        if (strike != 0)
            result.append(strike).append("스트라이크");
        if (strike == 0 && ball == 0)
            return "낫싱";
        result.append("\n");
        return result.toString();
    }

    private int getPointOfMatched() {
        return checkStrike() + checkBall();
    }

    private int checkStrike() {
        int result = 0;
        for (int i=0; i<3; i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i))
                result += 10;
        }
        return result;
    }

    private int checkBall() {
        int result = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i != j && computerNumber.charAt(i) == playerNumber.charAt(j))
                    result += 1;
            }
        }
        return result;
    }
}
