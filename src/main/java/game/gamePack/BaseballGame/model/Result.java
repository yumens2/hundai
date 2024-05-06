package game.gamePack.BaseballGame.model;

import game.gamePack.BaseballGame.view.OutputView;
import java.util.List;
import java.util.stream.IntStream;

public class Result {

    //private static Result result;

    private Result() {
    }

//    public static Result of() {
//        if (result == null) {
//            result = new Result();
//        }
//        return result;
//    }

    /**
     * static inner class를 이용한 싱글톤 패턴 클래스가 로딩될 때 생성되기 때문에 thread-safe 함 lazy loading이 가능하며, of()메소드가
     * 호출되기 전까지는 객체가 생성되지 않음
     */
    private static class ResultHolder {

        private static final Result result = new Result();
    }

    public static Result getInstance() {
        return ResultHolder.result;
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
