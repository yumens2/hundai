package baseball.model;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Score {
    private Integer strikeCount = 0;
    private Integer ballCount = 0;

    private static final Integer LENGTH = 3;

    private Score(Integer strikeCount, Integer ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Score getResults(String userNumber, List<Integer> computerNumbers) {
        List<Integer> userNumbers = userNumbers = userNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
        Integer strikeCount = getStrike(userNumbers, computerNumbers);
        Integer ballCount = getBall(userNumbers, computerNumbers, strikeCount);
        return new Score(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private static Integer getStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Integer strikeCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                    strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private static Integer getBall(List<Integer> userNumbers, List<Integer> computerNumbers, Integer strikeCount) {
        Integer ballCount;
        ballCount = (int) userNumbers.stream()
                .filter(computerNumbers::contains)
                .distinct()
                .count() - strikeCount;
        return ballCount;
    }



}
