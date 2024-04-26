package game;

import io.Input;
import io.Output;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomGame implements Game {
    private final Input input;
    private final Output output;
    private String computerNumber;
    private String playerNumber;

    public RandomGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }
    @Override
    public void play() {
        this.computerNumber = makeRandomNumber();
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

    private String makeRandomNumber() {
        Set<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (set.size() != 3)
            set.add(makeRandomNumber(1, 9));
        List<Integer> randomNumber = set.stream().collect(Collectors.toList());
        Collections.shuffle(randomNumber);
        for (int num : randomNumber)
            result.append(num);
        return result.toString();
    }

    private int makeRandomNumber(int start, int end) {
        return (int) (Math.random() * end) + start;
    }
}
