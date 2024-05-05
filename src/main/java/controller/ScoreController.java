package controller;

import model.BallCountStatus;
import model.Computer;
import model.User;

import java.util.ArrayList;

public class ScoreController {
    private static final String ALL_STRIKE_MESSAGE = "3스트라이크";
    private static final int MAX_SCORE = 3;
    private static final String NO_SCORE = "낫싱";

    public String calculateScore(User user, Computer computer) {
        ArrayList<BallCountStatus> ballCount = new ArrayList<>();

        compareScoreStrike(ballCount, user, computer);

        if (ballCount.size() == MAX_SCORE) {
            return ALL_STRIKE_MESSAGE;
        }

        compareScoreBall(ballCount, user, computer);

        return convertScoreListToString(ballCount);
    }

    protected void compareScoreBall(
            ArrayList<BallCountStatus> score, User user, Computer computer) {
        for (Integer userDatum : user.getNumberList()) {
            if (computer.getNumberSet().stream().anyMatch(userDatum::equals)
                    && score.size() <= MAX_SCORE) {
                score.add(BallCountStatus.Ball);
            }
        }
    }

    protected void compareScoreStrike(
            ArrayList<BallCountStatus> score, User user, Computer computer) {
        ArrayList<Integer> computerNumberList = new ArrayList<>(computer.getNumberSet());
        for (int i = 0; i < user.getNumberList().size(); i++) {
            if (computerNumberList.get(i).intValue() == user.getNumberList().get(i).intValue()) {
                score.add(BallCountStatus.Strike);
            }
        }
    }
    //
    protected String convertScoreListToString(ArrayList<BallCountStatus> score) {
        if (score.isEmpty()) {
            return NO_SCORE;
        } else {
            long ballNumber = getScoreCount(score, BallCountStatus.Ball);
            long strikeNumber = getScoreCount(score, BallCountStatus.Strike);
            ballNumber -= strikeNumber;
            String ballResult = (ballNumber) + "볼";
            String strikeResult = strikeNumber + "스트라이크";
            StringBuilder result = new StringBuilder();
            if (ballNumber > 0) {
                result.append(ballResult);
            }
            if (strikeNumber > 0) {
                if (ballNumber > 0) result.append(" ");
                result.append(strikeResult);
            }
            return result.toString();
        }
    }

    private long getScoreCount(ArrayList<BallCountStatus> score, BallCountStatus status) {
        return score.stream().filter(x -> x == status).count();
    }
}
