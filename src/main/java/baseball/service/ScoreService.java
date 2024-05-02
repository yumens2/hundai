package baseball.service;

import java.util.List;

public class ScoreService {

    private static final int LENGTH = 3;
    private int ball;
    private int strike;
    private int[] score = new int[2];
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public int[] getScore(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        resetScore();
        getStrike(playerNumbers, computerNumbers);
        getBall(playerNumbers, computerNumbers);
        return score;
    }

    public void resetScore() {
        score[STRIKE_INDEX] = 0;
        score[BALL_INDEX] = 0;
    }

    public void getStrike(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < LENGTH; i++) {
            if (isStrike(playerNumbers.get(i), computerNumbers.get(i))) {
                score[STRIKE_INDEX]++;
            }
        }
    }

    public boolean isStrike(int playerNumber, int computerNumber) {
        return playerNumber == computerNumber;
    }

    public void getBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < LENGTH; i++) {
            if (isBall(i, playerNumbers.get(i), computerNumbers)) {
                score[BALL_INDEX]++;
            }
        }
    }

    public boolean isBall(int idx, int playerNumber, List<Integer> computerNumbers) {
        return computerNumbers.get(idx) != playerNumber && computerNumbers.contains(playerNumber);
    }

}
