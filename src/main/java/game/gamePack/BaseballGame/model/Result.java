package game.gamePack.BaseballGame.model;

import game.gamePack.BaseballGame.view.OutputView;
import java.util.List;
import java.util.stream.IntStream;

public class Result {

    private static Result result;

    private Result() {
    }

    public static Result of() {
        if (result == null) {
            result = new Result();
        }
        return result;
    }

    public boolean getOutCome(List<Integer> computerNumbers, List<Integer> guessNumber) {
        int strikeCount = getStrikeCount(computerNumbers, guessNumber);
        int ballCount = getBallCount(computerNumbers, guessNumber);
        OutputView.printResult(strikeCount, ballCount);
        return strikeCount != computerNumbers.size();
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> guessNumber) {
        return (int) IntStream.range(0, computerNumbers.size())
            .filter(i -> computerNumbers.get(i).equals(guessNumber.get(i)))
            .count();
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> guessNumber) {
        return (int) guessNumber.stream()
            .filter(computerNumbers::contains)
            .count() - getStrikeCount(computerNumbers, guessNumber);
    }

}
